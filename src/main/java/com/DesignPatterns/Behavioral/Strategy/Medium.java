package com.DesignPatterns.Behavioral.Strategy;
//Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
//The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms into separate classes called strategies.
//https://medium.com/free-code-camp/the-strategy-pattern-explained-using-java-bc30542204e0
public class Medium {
}

abstract class Dog{
    abstract void display();

    void bark(){

    }
    void eat(){

    }
}

interface EatBehaviour{
    void eat();
}

interface BarkBehaviour{
    void bark();
}

class PlayfulBark implements BarkBehaviour{

    @Override
    public void bark() {
        System.out.println("Bark! Bark!");
    }
}

class Growl implements  BarkBehaviour{

    @Override
    public void bark() {
        System.out.println("this is a growl!");
    }
}

class MuteBark implements BarkBehaviour{

    @Override
    public void bark() {
        System.out.println("this is a mute bark!");
    }
}

class NormalDiet implements EatBehaviour{

    @Override
    public void eat() {
        System.out.println("This is a normal diet!");
    }
}

class ProteinDiet implements EatBehaviour{

    @Override
    public void eat() {
        System.out.println("this is a protein diet!");
    }
}

abstract class Dog2{
    EatBehaviour eatBehaviour;
    BarkBehaviour barkBehaviour;

    public Dog2() {
    }

    void doBark(){
        barkBehaviour.bark();
    }

    void doEat(){
        eatBehaviour.eat();
    }

    void setEatBehaviour(EatBehaviour behaviour){
        eatBehaviour = behaviour;
    }

    void setBarkBehaviour(BarkBehaviour behaviour){
        barkBehaviour = behaviour;
    }


}

class Labrador extends Dog2{
    public Labrador() {
        barkBehaviour = new PlayfulBark();
        eatBehaviour = new NormalDiet();
    }

    void display(){
        System.out.println("i am a playful labrador");
    }
}

class StrategyTester {
    public static void main(String[] args) {
        Dog2 lab = new Labrador();
        lab.doEat();
        lab.doBark();

        lab.setEatBehaviour(new ProteinDiet());
        lab.doEat();
        lab.doBark();
    }
}
