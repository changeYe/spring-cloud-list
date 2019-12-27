package com.ytq.study.multithread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yuantongqin
 * description:
 * 2019/12/11
 */
public class MyLock {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();



    }

    public void lockdemo(){
        lock.lock();


        // do something


        lock.unlock();
    }

    public void CountDownLatchDemo(){
        CountDownLatch latch = new CountDownLatch(10);

        latch.countDown();

    }
}
