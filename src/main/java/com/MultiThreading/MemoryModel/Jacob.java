package com.MultiThreading.MemoryModel;

//https://www.youtube.com/watch?v=LCSqZyjBwWA&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=3

public class Jacob {
}

class MyRunnable implements Runnable{
    private int count = 0;

    @Override
    public void run() {

        for(int i=0; i<1_000_000; i++){
            synchronized (this){
                this.count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + this.count);
    }
}

class SeperateObjects {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable();
//        Runnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "Thread1");
        Thread thread2 = new Thread(runnable1, "Thread2");
        thread1.start();
        thread2.start();
        //Thread1:1056734
        //Thread2:1056734
    }
}
