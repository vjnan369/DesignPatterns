package com.MultiThreading.ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample7 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));
        try{
            List<Future<String>> results = executorService.invokeAll(callables);
            for(Future future : results){
                System.out.println(future.get());
            }
        } catch (InterruptedException exception){

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
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
