package com.dp.SingletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String args[]){
        SingletonClass singletonClass1 = SingletonClass.getInstance();

        SingletonClass singletonClass2 = SingletonClass.getInstance();

        System.out.println("Instance 1 hash:" + singletonClass1.hashCode());
        System.out.println("Instance 2 hash:" + singletonClass2.hashCode());

        /*
        SingletonClass singletonClass3 = null;
        try {
            Class<SingletonClass> clazz = SingletonClass.class;
            Constructor<SingletonClass> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            singletonClass3 = cons.newInstance();

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        This provides different hashcode by using reflection
         */

        /*
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run(){
                SingletonClass ins1 = SingletonClass.getInstance();
            });
            Thread t2 = new Thread(new Runnable(){
                @Override
                    public void run(){
                    SingletonClass ins1 = SingletonClass.getInstance();
            });

            t1.start();
            t2.start();
         */
    }
}
