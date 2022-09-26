package com.MultiThreading.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceExample5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future future = executorService.submit(newCallable("Task 1.1"));
        System.out.println(future.isDone());
        try{
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException exception){

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Callable newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() {
                String message = Thread.currentThread().getName() + ": " + msg;
                System.out.println(message);
                return message;
            }
        };
    }
}
