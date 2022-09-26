package com.MultiThreading.RaceCondition;

//Make critical section atomic
public class RaceConditionExample {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(getRunnable(counter, "thread1 final count!"));
        Thread thread2 = new Thread(getRunnable(counter, "thread2 final count!"));

        thread1.start();
        thread2.start();

        CounterSynchronized counterSynchronized = new CounterSynchronized();
        Thread thread3 = new Thread(getRunnable(counterSynchronized, "thread3 final count!"));
        Thread thread4 = new Thread(getRunnable(counterSynchronized, "thread4 final count!"));

        thread3.start();
        thread4.start();
    }

    private static Runnable getRunnable(CounterSynchronized counter, String message){
        return () -> {
            for(int i=0; i<1_000_000; i++){
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
    }

    private static Runnable getRunnable(Counter counter, String message){
        return () -> {
          for(int i=0; i<1_000_000; i++){
              counter.incAndGet();
          }
            System.out.println(message + counter.get());
        };
    }
}

class Counter {
    private long count = 0;
    long incAndGet(){
        this.count++;
        return this.count;
    }

    long get(){
        return this.count;
    }
}

//Solution 1 -> synchronization
class CounterSynchronized {
    private long count = 0;
    long incAndGet(){
        synchronized (this){
            this.count++;
            return this.count;
        }
    }

    long get(){
        synchronized (this){
            return this.count;
        }
    }
}