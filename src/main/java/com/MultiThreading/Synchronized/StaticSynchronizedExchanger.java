package com.MultiThreading.Synchronized;

public class StaticSynchronizedExchanger {
    private static Object object = null;
    static synchronized void setObject(Object o){
        object = o;
    }

    static synchronized Object getObject(){
        return object;
    }

    static void setObj(Object o){
        synchronized (StaticSynchronizedExchanger.class){
            object = o;
        }
    }

    static Object getObj(){
        synchronized (StaticSynchronizedExchanger.class){
            return object;
        }
    }
}
