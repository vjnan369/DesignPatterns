package com.MultiThreading;

public class Tester {
}

class Example2 {
    static class MyThread extends Thread{
        public void run(){
            System.out.println("staretd!");
            System.out.println("ended!");
        }
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class Example3 {
    private int counter = 1;
    private boolean isEven = false;
    static class MyRunnable implements Runnable{

        public void run(){
            System.out.println("staretd runnable!");
            System.out.println("ended runnable!");
        }
    }
    public static void main(String[] args) {

//        Runnable runnable = () -> {
//            System.out.println("started!");
//            System.out.println("ended!");
//        };

        Example3 example3 = new Example3();
        MyRunnable myRunnable1 = new MyRunnable(){
            public void run(){
                example3.printOddNumber();
            }
        };
        MyRunnable myRunnable2 = new MyRunnable(){
            public void run(){
                example3.printEvenNumber();
            }
        };
        Thread thread1 = new Thread(myRunnable1, "t1");
        thread1.start();
        Thread thread2 = new Thread(myRunnable2, "t2");
        thread2.start();
    }

    private void printOddNumber(){
        synchronized (this){
            while(counter<10){
                while(isEven){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " " + " by " + Thread.currentThread().getName());
                counter++;
                isEven = true;
                notify();
            }
        }
    }
    private void printEvenNumber(){
        synchronized (this){
            while(counter<10){
                while(!isEven){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " "+ " by " + Thread.currentThread().getName());
                counter++;
                isEven = false;
                notify();
            }
        }
    }
}
