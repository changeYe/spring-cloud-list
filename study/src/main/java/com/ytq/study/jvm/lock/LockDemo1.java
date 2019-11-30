package com.ytq.study.jvm.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class LockDemo1 {

    public static void lockA(){
        Lock lock = new ReentrantLock();
        try {
            System.out.println("锁1 获取锁");
            lock.tryLock(4, TimeUnit.SECONDS);
            System.out.println("去获取锁2");
            Thread.sleep(1000);
            LockDemo2.lockB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (((ReentrantLock) lock).isLocked()) {
                lock.unlock();
            }
        }
    }

}
