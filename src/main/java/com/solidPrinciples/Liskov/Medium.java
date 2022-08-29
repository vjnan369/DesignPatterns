package com.solidPrinciples.Liskov;

// Derived classes should extend without replacing the functionality of old classes
//subtypes must be substitutable for their base classes.
//Objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.
//ex: visual studio 2005 can be substituted by vs2010 and it still works
//https://medium.com/@radheshyamsingh_83359/liskov-substitution-principle-solid-design-f9d48500c260
public class Medium {
}

// Violates LSP principle
//interface Bird {
//    public void eat();
//    public void fly();
//}

interface Bird {
    public void eat();
}

interface FlyingBird extends Bird {
    public void fly();
}

class Duck implements FlyingBird {

    @Override
    public void fly() {
        System.out.println("duck is flying");
    }

    @Override
    public void eat() {
        System.out.println("duck is eating");
    }
}

class Ostrich implements Bird {

    @Override
    public void eat() {
        System.out.println("Ostrich is eating");
    }
}

class TestBird {
    public static void main(String[] args) {
        FlyingBird bird = new Duck();
        bird.fly();
        Bird newBird = new Ostrich();
        newBird.eat();
    }
}

