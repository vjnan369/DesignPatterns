package com.MultiThreading.ExecutorService;

import sun.util.resources.cldr.ur.TimeZoneNames_ur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.shutdown();

        //all running tasks will be cancelled and shutdown now
        List<Runnable> runnables = executorService.shutdownNow();

        try{
            executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private static Callable newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() {
                String message = Thread.currentThread().getName() + ": " + msg;
                return message;
            }
        };
    }
}
