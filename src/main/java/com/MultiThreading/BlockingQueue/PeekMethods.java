package com.MultiThreading.BlockingQueue;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PeekMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        String element = blockingQueue.peek();
        try{
            String element2= blockingQueue.element();
        } catch (NoSuchElementException e){
            System.out.println("blocking queue emepty!");
        }
    }
}
