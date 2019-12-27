package com.ytq.study.multithread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
public class Run1 implements Runnable {

    private final Condition condition;
    private final Lock lock;

    public Run1(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
//            reinterrupt
            System.out.println("run1 获取到锁");
            condition.await();
            System.out.println("run1将当前线程挂起");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
