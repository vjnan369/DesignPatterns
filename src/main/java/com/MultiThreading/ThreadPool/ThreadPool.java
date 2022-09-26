package com.MultiThreading.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfThreads){
        taskQueue = new ArrayBlockingQueue(maxNoOfThreads);
        for(int i=0; i<noOfThreads; i++){
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }

        for(PoolThreadRunnable poolThreadRunnable : runnables){
            new Thread(poolThreadRunnable).start();
        }
    }

    public synchronized void execute(Runnable task){
        if(this.isStopped)
            throw new IllegalStateException("threadpool is stopped!");
        this.taskQueue.offer(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable : runnables){
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished(){
        while(taskQueue.size()>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
