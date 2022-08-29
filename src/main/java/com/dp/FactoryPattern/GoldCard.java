package com.dp.FactoryPattern;

public class GoldCard extends CardType{
    public GoldCard() {
        setCreditLimit();
    }

    @Override
    public void setCreditLimit() {
        creditLimit = 300000;
    }

    @Override
    public String toString() {
        return "GoldCard{" +
                "creditLimit=" + creditLimit +
                '}';
    }
}
