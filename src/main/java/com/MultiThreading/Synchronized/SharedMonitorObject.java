package com.MultiThreading.Synchronized;

public class SharedMonitorObject {
    private Object monitor = null;
    private int counter = 0;

    public SharedMonitorObject(Object monitor) {
        if(monitor == null){
            throw new IllegalArgumentException("Monitor object cannot be null!");
        }
        this.monitor = monitor;
    }

    public void incCounter(){
        synchronized (this.monitor){
            this.counter++;
        }
    }
}


class Tester3{
    public static void main(String[] args) {
        Object monitor1 = new Object();
        SharedMonitorObject sm1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject sm2 = new SharedMonitorObject(monitor1);
        sm1.incCounter();
        sm2.incCounter();

        Object monitor2 = new Object();
        SharedMonitorObject sm3 = new SharedMonitorObject(monitor2);
        sm3.incCounter();
    }
}