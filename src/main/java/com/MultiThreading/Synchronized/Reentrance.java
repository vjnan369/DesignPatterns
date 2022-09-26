package com.MultiThreading.Synchronized;

public class Reentrance {
    private int count = 0;
    public synchronized void inc(){
        this.count++;
    }

    public synchronized int incAndGet(){
        inc();
        return this.count;
    }
}
