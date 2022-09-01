package com.DesignPatterns.Prototype;
//Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.
//If the cost for creating a new object is expensive and costs resources.
//https://medium.com/javarevisited/prototype-design-pattern-java-79a100b0e4e8
public class Medium {
}

interface Prototype {
    public Prototype getClone();
}

class Human implements Prototype{
    private String name;
    private String lastName;
    private int age;

    public Human(){

    }

    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    private void showHuman(){
        System.out.println("print all human properties");
    }

    @Override
    public Prototype getClone() {
        return new Human(name, lastName, age);
    }
}

class PrototypeTest {
    public static void main(String[] args) {
        Human human1 = new Human("Jnan", "Vuyyala", 25);
        Human human2 = (Human) human1.getClone();
    }
}
