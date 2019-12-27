package com.ytq.study.multithread.thread.contend;

/**
 * @author yuantongqin
 * description:
 * 2019/12/10
 */
public class Thread3 extends Thread{

    private final Object object;

    public Thread3(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("thread3开始1");
        synchronized (this.object){

            System.out.println("thread3开始2");
            object.notifyAll();
//            try {
//                object.wait();
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("thread3开始3");

        }
    }
}
