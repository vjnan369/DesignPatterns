package com.MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(newRunnable("Task 1.1"));
        executorService.execute(newRunnable("Task 1.2"));
        executorService.execute(newRunnable("Task 1.3"));
        executorService.shutdown();
    }

    private static Runnable newRunnable(String msg){
        return new Runnable() {
            @Override
            public void run() {
                String message = Thread.currentThread().getName() + ": " + msg;
                System.out.println(message);
            }
        };
    }
}
