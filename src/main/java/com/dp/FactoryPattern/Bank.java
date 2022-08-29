package com.dp.FactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
It provides an interface to create object in the superclass but allows subclasses to
alter the type of object that will be created
https://medium.com/geekculture/overview-of-factory-method-design-pattern-d3a6fe908ea4
 */
public class Bank {
    public static void main(String args[]) throws IOException {
        System.out.println("Hello world!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Your salary: ");
        Integer salary = Integer.parseInt(br.readLine());
        String cardType = "";
        CardType cardTypeObject ;
        if(salary < 50000){
            cardType = "silver";
//            cardTypeObject = new SilverCard();
        } else if(salary < 100000){
            cardType = "gold";
//            cardTypeObject = new GoldCard();
        } else {
            cardType = "platinum";
//            cardTypeObject = new PlatinumCard();
        }

//        System.out.println(cardTypeObject);
        CardType mycard = CardFactory.getCard(cardType);
        System.out.println(mycard);
    }
}

//vuyyalamadhu138@gmail.com
//VuyyalaMadhu@138
//VuyyalaMadhu@138
