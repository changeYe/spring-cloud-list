package com.ytq.fault.hundred.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author yuantongqin
 * description:
 * 2020/3/17
 */
public class ThreadUtils {

    /**
     * 这里实现了最简陋的监控，每秒输出线程池的内部信息，线程数，活跃线程数，完成任务，队列中积压任务
     * @param threadPoolExecutor
     */
    public static void printStats(ThreadPoolExecutor threadPoolExecutor){
        if(threadPoolExecutor == null){
            return;
        }
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println("线程池大小："+threadPoolExecutor.getPoolSize());
            System.out.println("当前活动线程数："+threadPoolExecutor.getActiveCount());
            System.out.println("任务完成数量："+threadPoolExecutor.getCompletedTaskCount());
            System.out.println("阻塞队列中剩余任务数："+threadPoolExecutor.getQueue().size());
        }, 0, 1, TimeUnit.SECONDS);
    }

}
