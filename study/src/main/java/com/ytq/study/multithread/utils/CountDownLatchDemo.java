package com.ytq.study.multithread.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuantongqin
 * description:
 * 2019/12/16
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
        countDownLatch.countDown();

        System.out.println("bbbb");


    }



    public static class MyRun implements Runnable{

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("111"+name);

//            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("222"+Thread.currentThread().getName());

        }
    }



}
