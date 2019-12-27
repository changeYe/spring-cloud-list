package com.ytq.study.multithread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
public class ConditionDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new Run1(lock,condition)).start();
        new Thread(new Run2(lock,condition)).start();

    }

}
