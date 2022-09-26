package com.MultiThreading.BlockingQueue;

import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    BlockingQueue<String> blockingQueue = null;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            long timeMillis = System.currentTimeMillis();
            try{
                this.blockingQueue.put("" + timeMillis);
                sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted!");
            }
        }
    }
}
