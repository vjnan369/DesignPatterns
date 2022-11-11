package com.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(getRunnable("1.1"));
        executorService.shutdown();
    }

    private static Runnable getRunnable(String str){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("executing: " + Thread.currentThread().getName());
            }
        };
    }
}

