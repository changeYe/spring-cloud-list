package com.ytq.study.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuantongqin
 * description:
 * 2019/11/28
 */
public class DeadlockDemo {

    public static void main(String[] args) {
    DeadlockDemo deadlockDemo = new DeadlockDemo();
    deadlockDemo.ss();

    }

    public void ss(){
        MyThread mt = new MyThread();
        new Thread(mt).start();
        new Thread(mt).start();
    }

    class LockThread implements Runnable{
        Object o1 = new Object();
        Object o2 = new Object();
        boolean flag = false;
        @Override
        public void run() {
            if(flag){
                Lock readLock = new ReentrantLock();
                try {
                    readLock.tryLock(2, TimeUnit.SECONDS);

                    Lock read1 = new ReentrantLock();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if (((ReentrantLock) readLock).isLocked()) {
                        readLock.unlock();
                    }

                }
            }else{

            }
        }
    }

    class MyThread implements Runnable{

        Object o1   = new Object();
        Object o2   = new Object();
        boolean flag = true;

        @Override
        public void run() {

            if(flag){
                flag = false;
                synchronized (o1){
                    try {
                        System.out.println("o1嘿嘿嘿1");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println("o2嘿嘿嘿2");
                    }
                }

            }else{
                flag = true;
                synchronized (o2){
                    try {
                        System.out.println("o2哈哈哈哈2");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println("o1哈哈哈哈1");
                    }
                }

            }

        }

    }

}
