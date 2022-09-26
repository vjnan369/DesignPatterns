package com.DesignPatterns;

import com.SolidPrinciples.Test;

public class Tester{

}

interface Prototype {
    public Prototype clone();
}

class Human implements Prototype{
    private String name;
    private String age;
    private String city;

    public Human(String name, String age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public Prototype clone() {
        return new Human(name, age, city);
    }
}

class Main{
    public static void main(String[] args) {
        Human h1 = new Human("234", "sdf", "sfdds");
        Human h2 = (Human) h1.clone();
    }
}