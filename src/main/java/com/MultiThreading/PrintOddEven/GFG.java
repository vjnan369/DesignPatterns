package com.MultiThreading.PrintOddEven;

//https://www.geeksforgeeks.org/print-even-and-odd-numbers-in-increasing-order-using-two-threads-in-java/
public class GFG {
    int count = 1;
    int n = 10;

    void printEvenNumber(){
        synchronized (this){
            while (count<n){
                while(count%2 == 1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " printing: " + count++);
                notify();
            }

        }
    }

    void printOddNumber(){
        synchronized (this){
            while(count<n){
                while(count%2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " printing: " + count++);
                notify();
            }
        }
    }

    public static void main(String[] args) {
        GFG gfg = new GFG();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                gfg.printEvenNumber();
            }
        };

        Runnable runnable2 = new Runnable(){
          public void run(){
              gfg.printOddNumber();
          }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2. start();
    }
}
