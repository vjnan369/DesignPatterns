package com.DesignPatterns.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
//A behavioral design pattern for Flexible Notification-Registration Interaction.
//Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
//https://medium.com/javarevisited/observer-design-pattern-in-java-e7e754bc95ef
//Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
public class Medium {
}

interface Product{
    void register(Subscriber subscriber);

    void unregister(Subscriber subscriber);

    void notifySubscribers();

    void postMessage(String message);
}

interface Subscriber {
    void update();

    void update(String message);
}

class OnePlusSubscriber implements Subscriber{
    String name = null;
    OnePlusPhone publisher;
    public OnePlusSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update() {

    }

    @Override
    public void update(String message) {
        if(message != null){
            System.out.println( "Hey, "  +name + ", new Message arrived, message: " + message);
        } else {
            System.out.println("no new message arrived!");
        }
    }
}

class OnePlusPhone implements Product{
    List<Subscriber> subscribers = null;
    String message = null;

    public OnePlusPhone() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void register(Subscriber subscriber) {
        if(subscriber == null){
            throw new NullPointerException();
        }
        subscribers.add(subscriber);
    }

    @Override
    public void unregister(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        if(subscribers != null && !subscribers.isEmpty()){
            for(Subscriber subscriber : subscribers){
                subscriber.update(message);
            }
        } else {
            System.out.println("No subscribers to notify!");
        }
    }

    @Override
    public void postMessage(String message) {
        System.out.println("new Message has published to topic! " + message);
        this.message = message;
        notifySubscribers();
    }
}

class ObserverTest{
    public static void main(String[] args) {
        List<Subscriber> list = new ArrayList<>();
        for(int i=1; i<=5; i++){
            list.add(new OnePlusSubscriber("Jnaneshwar"  + i));
        }

        Product product = new OnePlusPhone();
        for(Subscriber subscriber : list){
            product.register(subscriber);
        }

        product.postMessage("New Oneplus model has been released!");
    }
}
