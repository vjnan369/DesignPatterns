package com.MultiThreading.JavaLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        //do something
        lock.unlock();
    }
}

//using synchronized lock
class CounterSynchronized{
    private long count = 0;
    synchronized void inc(){
        count++;
    }

    synchronized long getCount(){
        return this.count;
    }
}

//using lock with lock
class CounterLock{
    private long count = 0;
    private Lock lock = new ReentrantLock();
    public void inc(){
        try {
            lock.lock();
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    public long getCount(){
        try {
            lock.lock();
            return this.count;
        } finally {
            lock.unlock();
        }
    }
}
