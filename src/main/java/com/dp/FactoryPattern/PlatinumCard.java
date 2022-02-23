package com.dp.FactoryPattern;


public class PlatinumCard extends CardType {

    public PlatinumCard() {
        setCreditLimit();
    }

    @Override
    public void setCreditLimit() {
        creditLimit = 500000;
    }

    @Override
    public String toString() {
        return "PlatinumCard{" +
                "creditLimit=" + creditLimit +
                '}';
    }
}
