package com.MultiThreading.Synchronized;

//https://www.youtube.com/watch?v=eKWjfZ-TUdo&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=5
public class Jacob {
}

class SyncrhonizedExchanger{
    protected Object object = null;
    synchronized void setObject(Object o){
        this.object = o;
    }

    synchronized Object getObject(){
        return this.object;
    }

    void setObj(Object o){
        synchronized (this){
            this.object = o;
        }
    }

    Object getObj(){
        synchronized (this){
            return this.object;
        }
    }
}

class Tester{
    public static void main(String[] args) {
        SyncrhonizedExchanger exchanger = new SyncrhonizedExchanger();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000; i++){
                    exchanger.setObject("" + i);
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000; i++){
                    System.out.println(exchanger.getObject());
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();;
        thread2.start();
    }
}


