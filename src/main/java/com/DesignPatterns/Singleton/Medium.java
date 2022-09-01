package com.DesignPatterns.Singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
//Provide a global access point to that instance
// ex: database connections,sockets, files
//https://medium.com/@kevalpatel2106/how-to-make-the-perfect-singleton-de6b951dfdb0
public class Medium {
}


class SingletonClass implements Serializable {
    //1. Eager Initialization
//    private static volatile SingletonClass singletonInstance = new SingletonClass();

    private static volatile SingletonClass singletonInstance;
    private SingletonClass(){
        //Prevent from the reflection API.
        if(singletonInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    // public synchronized static SingletonClass getInstance(){
    public static SingletonClass getInstance(){
        //2. Lazy Initialization
        if(singletonInstance == null)
            synchronized (SingletonClass.class){
                if(singletonInstance == null)
                    singletonInstance = new SingletonClass();
            }
        return singletonInstance;
    }

    //Make singleton from serialize and deserialize operation
    protected SingletonClass readResolve(){
        return getInstance();
    }
}

class SingletonTest{
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        System.out.println("instance 1 hash: "+ instance1.hashCode());
        System.out.println("instance 2 hash: "+ instance2.hashCode());

        //Testing with reflection API
        /*
        SingletonClass instance3 = null;
        Class<SingletonClass> clazz = SingletonClass.class;
        try {
            Constructor<SingletonClass> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance3 = cons.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("instance 2 hash: "+ instance2.hashCode());
        System.out.println("instance 3 hash: "+ instance3.hashCode());
         */

        //Thread safe testing
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass instance4 = SingletonClass.getInstance();
                System.out.println("instace4 hash: " +instance4.hashCode());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass instance5 = SingletonClass.getInstance();
                System.out.println("instace5 hash: " + instance5.hashCode());
            }
        });

        //Singleton class is not thread safe.
        //Solution -> make getInstance() synchronized
        t1.start();
        t2.start();
    }
}
