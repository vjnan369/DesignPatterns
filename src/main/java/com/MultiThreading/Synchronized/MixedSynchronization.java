package com.MultiThreading.Synchronized;

public class MixedSynchronization {
    static Object staticObj = null;

    static synchronized void setStaticObj(Object obj){
        staticObj = obj;
    }

    Object instanceObj = null;
    synchronized void setInstanceObj(Object obj){
        this.instanceObj = obj;
    }
}
