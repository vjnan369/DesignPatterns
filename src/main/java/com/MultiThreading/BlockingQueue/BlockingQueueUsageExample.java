package com.MultiThreading.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueUsageExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<>(3);
        blockingQueue.put("element 1");
        blockingQueue.put("element 2");

        String element1 = blockingQueue.take();
        String element2 = blockingQueue.take();

        System.out.println(element1);
        System.out.println(element2);
    }
}
