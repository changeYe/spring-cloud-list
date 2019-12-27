package com.ytq.study.multithread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
public class Run2 implements Runnable {

    private final Condition condition;
    private final Lock lock;

    public Run2(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("run2 获取到锁");
            condition.signal();
            System.out.println("run2唤醒Condition对象挂起的线程");

        } finally {
            lock.unlock();
        }

    }
}
