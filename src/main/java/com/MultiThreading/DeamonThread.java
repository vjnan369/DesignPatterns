package com.MultiThreading;

import static java.lang.Thread.sleep;

//Deamon threads stops after main thread terminates
public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true){
                try {
                    sleep(1000);
                    System.out.println("thread running!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3000);
    }
}
