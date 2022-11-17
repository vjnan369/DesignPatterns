package com.MachineCoding.Splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User{
    private String id;
    private String name;
    private String email;
    private String phone;

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class Split{
    private User user;
    double amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class EqualSplit extends Split{

    public EqualSplit(User user) {
        super(user);
    }
}

class ExactSplit extends Split{

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}

class PercentSplit extends Split{
    double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}

class ExpenseMetadata{
    private String name;
    private String imgUrl;
    private String notes;

    public ExpenseMetadata(String name, String imgUrl, String notes) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

abstract class Expense{
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetadata metadata;

    public Expense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ExpenseMetadata metadata) {
        this.metadata = metadata;
    }

    public abstract boolean validate();
}

class EqualExpense extends Expense{

    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {
        for(Split split : getSplits()){
            if(!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;
    }
}

class ExactExpense extends Expense{

    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {
        for(Split split : getSplits()){
            if(!(split instanceof ExactSplit)){
                return false;
            }
        }
        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for(Split split : getSplits()){
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }
        if(totalAmount != sumSplitAmount)
            return false;
        return true;
    }
}

class PercentExpense extends Expense{

    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {
        for(Split split : getSplits()){
            if(!(split instanceof ExactSplit)){
                return false;
            }
        }
        double totalPercent = 100;
        double sumSplitPercent = 0;
        for(Split split : getSplits()){
            PercentSplit splitPercent = (PercentSplit) split;
            sumSplitPercent += splitPercent.getPercent();
        }
        if(totalPercent != sumSplitPercent)
            return false;
        return true;
    }
}

enum ExpenseType{
    EQUAL,
    EXACT,
    PERCENT
}

class ExpenseService{
    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata){
        switch (expenseType){
            case EXACT:
                return new ExactExpense(amount, paidBy, splits, expenseMetadata);
            case PERCENT:
                for(Split split : splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new ExactExpense(amount, paidBy, splits, expenseMetadata);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double)(amount*100/totalSplits))/100.0;
                for(Split split : splits){
                    split.setAmount(splitAmount);
                }
                return new ExactExpense(amount, paidBy, splits, expenseMetadata);
            default:
                return null;
        }
    }
}

class ExpenseManager{
    List<Expense> expenses;
    Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }
    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetadata expenseMetadata){
        Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splits, expenseMetadata);
        expenses.add(expense);
        for(Split split : expense.getSplits()){
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            balances.put(paidTo, balances.getOrDefault(paidTo, 0.0) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            balances.put(paidBy, balances.getOrDefault(paidBy, 0.0)-split.getAmount());
        }
    }

    public void showBalance(String userId){
        boolean isEmpty = true;
        for(Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()){
            if(userBalance.getValue() > 0){
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if(isEmpty){
            System.out.println("No Balances!");
        }
    }

    public void showBalances(){
        boolean isEmpty = true;
        for(Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()){
            for(Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()){
                if(userBalance.getValue() > 0){
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }
        if(isEmpty){
            System.out.println("No Balances!");
        }
    }

    private void printBalance(String user1, String user2, Double amount){
        String username1 = userMap.get(user1).getName();
        String username2 = userMap.get(user2).getName();
        if(amount < 0){
            System.out.println(username1 + " owes " + username2 + " : " +Math.abs(amount));
        } else if(amount>0){
            System.out.println(username2 + " owes " + username1 + " : " + Math.abs(amount));
        }
    }
}

public class Splitwise {
}

