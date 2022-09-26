package com.MultiThreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<String> blockingQueue = null;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                String element = this.blockingQueue.take();
                String text = Thread.currentThread().getName() + ", consumed " +element;
                System.out.println(text);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
