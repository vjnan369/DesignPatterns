package com.MultiThreading.ExecutorService;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample9 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future future = executorService.submit(newCallable("Task 1.1"));

        System.out.println(future.isDone());

        boolean mayInterrupt = false;
        boolean wasCancelled = future.cancel(mayInterrupt);
        System.out.println("iscancelled: " + wasCancelled);

        try{
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (CancellationException e){
            System.out.println("cannot call future.get() sincle task was cancelled!");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(future.isDone());
        System.out.println("iscancelled: " + future.isCancelled());
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
