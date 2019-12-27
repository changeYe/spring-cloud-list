package com.ytq.study.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuantongqin
 * description:
 * 2019/12/6
 */
public class BasicThread {

    public static void main(String[] args) {
//        Thread
//        Callable callable =
//        final ExecutorService service = Executors.newCachedThreadPool();
//        final Future<Object> submit = service.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                return null;
//            }
//        });
//        try {
//            submit.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        service.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

    }

    public void sa(){
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(16);
//        linkedBlockingQueue.put(null);
//        linkedBlockingQueue.peek();
//        linkedBlockingQueue.poll();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                                                                             0L, TimeUnit.MILLISECONDS,
                                                                             linkedBlockingQueue);


    }

    /**
     * 线程的状态
     */

    /**
     * 线程启动与终止的方式
     */
    public void threadStartOrStopWay(){
        Thread.interrupted();
        Thread t = new Thread(()->{});
        t.start();
        t.interrupt();
    }

    /**
     *
     */

    public void lock(){
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });

    }
}
