package com.ytq.study.jvm.executor;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class Producer implements Runnable{

    BlockingDeque<String > deque;
    public Producer(BlockingDeque<String > blockingDeque){
        this.deque = blockingDeque;
    }

    @Override
    public void run() {

        String data = null;
        Random  r = new Random();

        data = data + ""+r.nextInt(100);

        try {
            deque.offer(data, 2, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
