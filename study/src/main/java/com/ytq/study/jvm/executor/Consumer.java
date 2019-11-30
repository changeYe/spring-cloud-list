package com.ytq.study.jvm.executor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class Consumer implements Runnable{

    BlockingDeque<String > deque;
    public Consumer(BlockingDeque<String > blockingDeque){
        this.deque = blockingDeque;
    }

    @Override
    public void run() {

        try {
            String poll = deque.poll(2, TimeUnit.SECONDS);
            System.out.println("消费数据:"+poll);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
