package com.MultiThreading.JavaLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//
public class LockInturruptExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        try{
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException exception){
            System.out.println("thread interrupted!");
        }
    }
}
