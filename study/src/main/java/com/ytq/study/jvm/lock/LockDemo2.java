package com.ytq.study.jvm.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class LockDemo2 {


    public static void lockB(){
        Lock lock = new ReentrantLock();
        try {
            System.out.println("锁2 获取锁");
            lock.tryLock(4, TimeUnit.SECONDS);
            Thread.sleep(1000);
            System.out.println("去获取锁1");
            LockDemo1.lockA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (((ReentrantLock) lock).isLocked()) {
                lock.unlock();
            }
        }
    }
}
