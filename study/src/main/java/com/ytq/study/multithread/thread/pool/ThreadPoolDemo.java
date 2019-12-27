package com.ytq.study.multithread.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuantongqin
 * description:
 * 2019/12/14
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
         ExecutorService service = Executors.newFixedThreadPool(5);
         ExecutorService service1 = Executors.newFixedThreadPool(10);
    }

}
