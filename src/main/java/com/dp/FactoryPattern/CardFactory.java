package com.dp.FactoryPattern;

public class CardFactory {
    public static CardType getCard(String type){
        switch (type){
            case "silver":
                return new SilverCard();
            case "gold":
                return new GoldCard();
            case "platinum":
                return new PlatinumCard();
            default:
                return null;
        }
    }
}
