package com.ytq.study.jvm.lock;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class LockDemo {

    public static void main(String[] args) {
        LockDemo1.lockA();
        LockDemo2.lockB();
    }

}
