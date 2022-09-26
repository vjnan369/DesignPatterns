package com.MultiThreading.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceExample2 {
    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 20;
        int keepAliveTime = 3000;

        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(128)
                );

        threadPoolExecutor = Executors.newFixedThreadPool(3);

        ExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }
}
