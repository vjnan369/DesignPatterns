package com.SolidPrinciples;
//SOLID
//Liscov substitution principle

public class Test {
}

interface BankCard{
    void doPayment();
}

class DebitCard implements BankCard{
    @Override
    public void doPayment(){
        //do payment
    }
}

class CreditCard implements BankCard{
    @Override
    public void doPayment(){
        //do payment
    }
}

class ShoppingMall{
    BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public static void main(String[] args) {
        BankCard debitCard = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(debitCard);
        debitCard.doPayment();
    }
}




