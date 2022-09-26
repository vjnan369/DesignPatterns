package com.MultiThreading.DeamonThread;

import static java.lang.Thread.sleep;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for(int i=0; i<5; i++){
                try {
                    sleep(1000);
                    System.out.println("Running!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        //This will enable to wait the main thread to exit till the deamon thread completes the process
        thread.join();
    }
}
