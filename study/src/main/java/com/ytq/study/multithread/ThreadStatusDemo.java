package com.ytq.study.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuantongqin
 * description:
 * 2019/12/9
 */
public class ThreadStatusDemo {
    final static ReentrantLock lock1 = new ReentrantLock();
    final static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        threadStatus();
    }


    public static void threadStatus(){
        new Thread(()->{
            try {
                // 沉睡3秒
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"timeout-thread").start();
    }
    static int i= 0;
    public static void interupt(){

        Thread thread=new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Num:"+i);
        },"interruptDemo");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void deadLock(){

        Object object1 = new Object();
        Object object2 = new Object();
        final MyThread1 myThread1 = new MyThread1(object1, object2);
        myThread1.start();

//        myThread1.stop();
//        if(!myThread1.isInterrupted()){
//            myThread1.interrupt();
//        }

        final MyThread2 myThread2 = new MyThread2(object1, object2);
        myThread2.start();

//        new MyThread3().start();
//        new MyThread4().start();

    }


    /**
     * 判断如果在指定时间内没还有获取到锁,进行锁的释放
     */
    static class MyThread3 extends Thread {

        @Override
        public void run() {
            lock1.lock();
            System.out.println("线程1 获取第一把锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock2.tryLock(1, TimeUnit.SECONDS);
                System.out.println("线程1获取第二把锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }

            }

            lock1.unlock();
        }

    }

    static class MyThread4 extends Thread {

        @Override
        public void run() {

            lock2.lock();
            System.out.println("线程2 获取第一把锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock1.tryLock(2, TimeUnit.SECONDS);
                System.out.println("线程2获取第二把锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
            }

            lock2.unlock();
        }
    }


    static class MyThread1 extends Thread {

        Object object1;
        Object object2;

        public MyThread1(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            synchronized (object1) {
                System.out.println("线程1 获取第一把锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                stop();
                if(!isInterrupted()){
//                    interrupt();
                    Thread.interrupted();
                }
                synchronized (object2) {
                    System.out.println("线程1获取第二把锁");
                }
            }
        }
    }

    static class MyThread2 extends Thread {

        Object object1;
        Object object2;

        public MyThread2(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            synchronized (object2) {
                System.out.println("线程2 获取第一把锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("线程2获取第二把锁");
                }
            }
        }
    }

}
