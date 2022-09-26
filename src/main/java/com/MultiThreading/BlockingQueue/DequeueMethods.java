package com.MultiThreading.BlockingQueue;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DequeueMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //take() blocks until an element becomes available
        try {
            String element = blockingQueue.take();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //poll() returns null if no element is available
        String element2  =  blockingQueue.poll();

        //blocks until timeout
        //for an element to  become available if no elemenet is available returns null;
        try{
            String element3  =  blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //removes the element if present in the blockingqueue
        boolean wasRemoved = blockingQueue.remove("1");
    }
}
