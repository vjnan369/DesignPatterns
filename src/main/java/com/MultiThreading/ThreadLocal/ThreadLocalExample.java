package com.MultiThreading.ThreadLocal;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            threadLocal.set("thread1");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            String value = threadLocal.get();
            System.out.println(value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(value);
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("thread2");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }

            String value = threadLocal.get();
            System.out.println(value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(value);
        });

        thread1.start();
        thread2.start();
    }
}
