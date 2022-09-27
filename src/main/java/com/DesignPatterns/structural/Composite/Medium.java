package com.DesignPatterns.structural.Composite;

import java.util.ArrayList;
import java.util.List;

//Composite is a structural design pattern that lets you compose objects into tree structures and then work with
// these structures as if they were individual objects.
//The Composite pattern lets you run a behavior recursively over all components of an object tree.
//https://medium.com/javarevisited/composite-design-pattern-java-9cd0964d3b12
//When we want to implement the same interface on leaves and composites so that they are handled in the same way.
public class Medium {
}

interface Human{
    String getName();
    String getLastName();
    void print();
    void addChild(Human child);
    void addParent(Human parent);
}

class GrandParent implements Human{
    private String name;
    private String lastName;

    public GrandParent(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void print() {
        System.out.println("grandparent and their dependent details: ");
    }

    private List<Human> childs = new ArrayList<>();
    @Override
    public void addChild(Human child) {
        childs.add(child);
    }

    @Override
    public void addParent(Human parent) {

    }
}

class Parent implements Human{
    private String name;
    private String lastName;

    public Parent(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void print() {
        System.out.println("parent information!");
    }

    private List<Human> children = new ArrayList<>();
    @Override
    public void addChild(Human child) {
        children.add(child);
    }

    private List<Human> parents = new ArrayList<>();
    @Override
    public void addParent(Human parent) {
        parents.add(parent);
    }
}

class Child implements Human {
    private String name;
    private String lastName;

    public Child(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void print() {
        System.out.println("children info!");
    }

    @Override
    public void addChild(Human child) {

    }

    List<Human> parents = new ArrayList<>();
    @Override
    public void addParent(Human parent) {
        parents.add(parent);
    }
}

class CompositeMain {

    public static void main(String[] args) {

        Child mathys = new Child("Mathys", "Le Tutour");
        Parent erwan = new Parent("Erwan", "Le Tutour");
        Parent amelie = new Parent("Amelie", "Le Tutour");

        mathys.addParent(erwan);
        mathys.addParent(amelie);
        erwan.addChild(mathys);
        amelie.addChild(mathys);

        GrandParent philippe = new GrandParent("Philippe", "Le Tutour");

        philippe.addChild(erwan);
        erwan.addParent(philippe);

        philippe.print();
        erwan.print();
        mathys.print();
    }
}


