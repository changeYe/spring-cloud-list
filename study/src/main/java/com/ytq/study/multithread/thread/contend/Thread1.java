package com.ytq.study.multithread.thread.contend;

/**
 * @author yuantongqin
 * description:
 * 2019/12/10
 */
public class Thread1 extends Thread{

    private final Object object;

    public Thread1(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("thread1开始1");
        synchronized (this.object){

            System.out.println("thread1开始2");
            try {
                object.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1开始3");

        }
    }
}
