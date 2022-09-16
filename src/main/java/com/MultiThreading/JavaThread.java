package com.MultiThreading;

public class JavaThread {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
    }
}

class ThreadExample2{
    static class MyThread extends Thread{
        public void run() {
            System.out.println("my thread running!");
            System.out.println("my thread stopped!");
        }
    }

    public static void main(String[] args) {
        MyThread thread  = new MyThread();
        thread.start();
    }
}

class ThreadExample3 {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("my runnable running!");
            System.out.println("my runnable stopped!");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}

class ThreadExample4 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("runnable FI started!");
                System.out.println("runnable FI ended!");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class ThreadExample5 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("lambda running!");
            System.out.println("lambda finished!");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class ThreadExample6 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running!");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " ended!");
        };
        Thread thread1 = new Thread(runnable, "thread1");
        thread1.start();
        Thread thread2 = new Thread(runnable, "thread2");
        thread2.start();
    }
}

class ThreadExample7 {
    public static class StoppableRunnable implements Runnable{
        private boolean stopRequested = false;
        public synchronized void requestStop(){
            stopRequested = true;
        }
        public synchronized boolean isStopRequested(){
            return this.stopRequested;
        }
        @Override
        public void run() {
            System.out.println("thread running!");
            while (!stopRequested){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread stopped!");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable runnableThread = new StoppableRunnable();
        Thread thread1 = new Thread(runnableThread);
        thread1.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnableThread.requestStop();
    }
}

