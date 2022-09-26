package com.MultiThreading.JavaLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//testing reentrant locks
// lock doesn't guarantee fairness, there is a chance that thread2 can go starvation while
// waiting for lock to lock.
//A Java Lock can be reentrant, meaning the same thread can lock the Lock more than one time.
// The Lock must then be unlocked the same number of times before it is fully unlocked for other threads.
public class Calculator {
    public static class Calculation{
        public static final int UNSPECIFIED = -1;
        public static final int ADDITION = 0;
        public static final int SUBTRACTION = 1;
        int type = UNSPECIFIED;

        public double value;

        public Calculation(int type, double value){
            this.type = type;
            this.value = value;
        }

        private double result = 0.0D;
        Lock lock = new ReentrantLock();

        public void add(double value){
            try {
                lock.lock();
                this.result += value;
            } finally {
                lock.unlock();
            }
        }

        public void subtract(double value){
            try{
                lock.lock();
                this.result -= value;
            } finally {
                lock.unlock();
            }
        }

        public void calculate(Calculation ... calculations){
            try{
                lock.lock();
                for(Calculation calculation : calculations){
                    switch (calculation.type){
                        case Calculation.ADDITION :
                            add(calculation.value);
                            break;
                        case Calculation.SUBTRACTION:
                            subtract(value);
                            break;
                    }
                }
            } finally {
                lock.unlock();
            }
        }

    }
}
