package com.MultiThreading.ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//Invoke any to get response from faster thread .
// to be used when we are hitting multiple services to get the result and need any one service response
public class ExecutorServiceExample6 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));
        try{
            String result = (String) executorService.invokeAny(callables);
            System.out.println(result);
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
