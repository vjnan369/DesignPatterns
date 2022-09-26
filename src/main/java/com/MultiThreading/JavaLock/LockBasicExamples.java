package com.MultiThreading.JavaLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

// to maintain fairness
public class LockBasicExamples {
    public static void main(String[] args) {
        lockBasics();
    }

    private static void lockBasics(){
        //set true if you want to have fairness in lock
        //Lock lock = new ReentrantLock(false);
        Lock lock = new ReentrantLock(false);
        Runnable runnable = () -> {
            lockSleepUnlock(lock, 1000);
        };

        Thread t1 = new Thread(runnable, "thread1");
        Thread t2 = new Thread(runnable, "thread2");
        Thread t3 = new Thread(runnable,  "thread3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static void lockSleepUnlock(Lock lock, long time){
        try{
            lock.lock();
            System.out.println("holds the lock!");
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
