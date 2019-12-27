package com.ytq.study.multithread.thread.contend;

/**
 * @author yuantongqin
 * description:
 * 2019/12/10
 */
public class Thread2 extends Thread{

    private final Object object;

    public Thread2(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("thread2开始1");
        synchronized (this.object){

//            System.out.println("thread2开始2");
//            object.notify();
            System.out.println("thread2开始3");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2开始4");

        }
    }
}
