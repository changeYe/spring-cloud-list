package com.ytq.study.multithread.thread.contend;

/**
 * @author yuantongqin
 * description:
 * 2019/12/10
 */
public class ThreadMain {

    public static void main(String[] args) {
        Object o = new Object();
        new Thread1(o).start();
        new Thread2(o).start();
        new Thread3(o).start();
    }

}
