package com.practice.ThreadExamples;

import java.util.concurrent.*;

public class Task implements Callable<String> {
    private final String message;

    public Task(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + ": " + message ;
    }
}

class Tester2{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Task task = new Task("test message");
        Future future = executorService.submit(task);
        System.out.println(future.isDone());
        try {
            String message = (String) future.get();
            System.out.println(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
