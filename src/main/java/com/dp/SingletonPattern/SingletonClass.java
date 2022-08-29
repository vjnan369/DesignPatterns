package com.dp.SingletonPattern;

public class SingletonClass {
    private volatile static SingletonClass singletonClass;
    private SingletonClass(){
        if(singletonClass != null){
            throw new RuntimeException("already singleton access created. you cant create new");
        }
    }

    public static SingletonClass getInstance(){
        if (singletonClass == null){
            synchronized (SingletonClass.class){
                if (singletonClass == null){
                    singletonClass = new SingletonClass();
                }
            }
        }

        return singletonClass;
    }
}
