package com.ytq.study.jvm;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import com.ytq.study.jvm.executor.Consumer;
import com.ytq.study.jvm.executor.Producer;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class LinkedQueueDemo {

    public static void main(String[] args) {
        BlockingDeque<String > blockingDeque = new LinkedBlockingDeque<>();

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            Producer producer = new Producer(blockingDeque);
            service.execute(producer);

        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(blockingDeque);
            service.execute(consumer);
        }


    }

}
