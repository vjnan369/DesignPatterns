package com.dp.FactoryPattern;

public class SilverCard extends CardType{
    public SilverCard(){
        setCreditLimit();
    }
    @Override
    public void setCreditLimit() {
        creditLimit = 150000;
    }

    @Override
    public String toString() {
        return "SilverCard{" +
                "creditLimit=" + creditLimit +
                '}';
    }
}
