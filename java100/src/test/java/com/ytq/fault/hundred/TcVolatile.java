package com.ytq.fault.hundred;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * @author yuantongqin
 * description:
 * 2020/4/8
 */
public class TcVolatile {

    public static volatile int m = 0;


    @Test
    public void ta() throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    m ++;
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach(info->info.start());
        latch.await();
        System.out.println(m);

        ConcurrentHashMap chm = new ConcurrentHashMap();
    }

}
