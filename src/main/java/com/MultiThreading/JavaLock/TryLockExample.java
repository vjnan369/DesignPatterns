package com.MultiThreading.JavaLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    1. sychronized blocks must be contained within a single method
        lock.lock() and lock.unlock() can be called from different methods;
    2.  lock.lock() and lock.unlock() provides same visibility and happens before guarantees as entering
         and exiting a synchronized block.
    3.  synchronized blocks are always reentrant. lock could decide not to be.
    4. syncrhonized blocks do not guarantee fairness, locks can.
 */
public class TryLockExample {
    public static void main(String[] args) throws InterruptedException {
        tryLock();
    }

    private static void tryLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        try{
            boolean lockSuccessful = lock.tryLock();
            // TO MAINTAIN THE FAIRNESS
//            boolean lockSuccessful = lock.tryLock(1000, TimeUnit.MILLISECONDS);
            System.out.println("lock successful!: "+ lockSuccessful);
        } finally {
            lock.unlock();
        }
    }
}
