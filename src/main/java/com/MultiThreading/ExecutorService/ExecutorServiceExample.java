package com.MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//https://amanagrawal9999.medium.com/the-thread-and-the-executor-framework-5b016ea7f897
//https://amanagrawal9999.medium.com/the-steeler-fork-join-framework-acdf15c451bd
public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 3"));
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
