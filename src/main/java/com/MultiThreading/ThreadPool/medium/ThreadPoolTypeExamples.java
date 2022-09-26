package com.MultiThreading.ThreadPool.medium;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTypeExamples {
    //creates a thread pool with 10 fixed threds
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    //Creates a thread pool that creates new threads as needed. This will reuse previously constructed threads when they are available.
    ExecutorService executorService2 = Executors.newCachedThreadPool();

    // creates single trhead.
    ExecutorService executorService3 = Executors.newSingleThreadExecutor();
}
