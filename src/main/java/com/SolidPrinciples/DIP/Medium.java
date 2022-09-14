package com.SolidPrinciples.DIP;

//Dependency Inversion Principle (DIP)
//we must use abstraction (abstract classes and interfaces) instead of concrete implementations. High-level modules should not depend on the low-level module but both should depend on the abstraction
//High-level modules should not depend on low-level modules. Both should depend on abstractions.
//Abstractions should not depend on details. Details should depend on abstractions.
public class Medium {}

class DebitCard{
    public void doTransaction(int amount){
        //transaction logic
    }
}

class CreditCard{
    public void doTransaction(int amount){
        //transaction logic
    }
}

//Shopping mall is tightly coupled with DebitCard. it fails if user tries with CreditCard
class ShoppingMall {
    private DebitCard debitCard;
    public ShoppingMall(DebitCard debitCard){
        this.debitCard = debitCard;
    }
    public void doPayment(int amount){
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(debitCard);
        shoppingMall.doPayment(5000);
    }
}

//Solution

interface BankCard {
    public void doTransaction(int amount);
}

class CreditCard2 implements BankCard{

    @Override
    public void doTransaction(int amount) {}
}

class DebitCard2 implements BankCard{

    @Override
    public void doTransaction(int amount) {

    }
}

//It supports all kind of cards
class ShoppingMall2 {
    private BankCard bankCard;

    public ShoppingMall2(BankCard bankCard){
        this.bankCard = bankCard;
    }

    public void doPayment(int amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        BankCard card = new CreditCard2();
        ShoppingMall2 shoppingMall2 = new ShoppingMall2(card);
        shoppingMall2.doPayment(5000);
    }
}




