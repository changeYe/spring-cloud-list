package com.ytq.fault.hundred;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * @author yuantongqin
 * description:
 * 2020/3/16
 */
public class Ta {

    public void tb(){

        List<String> a= new ArrayList<>();
        boolean aa = a.contains(null);
        System.out.println(aa);

//        Collection

//        ArrayList al = null;
////        al.add()
//        LinkedList l = null;
//        l.getLast();

//        Set<String> hs = new HashSet<>();
//        hs.add(null);
//        System.out.println(hs.size());
//
//        LinkedHashSet<String> lhs = new LinkedHashSet<>();
//        lhs.add("aa");
//
//        LinkedHashMap<String,String> lhm = new LinkedHashMap<>();
//        lhm.put("aaa","ccc");

//        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(16);
//        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue(16);
//        abq.add("aaa");
//        abq.add("bbb");
//        abq.add("ccc");
//        System.out.println(abq.size());
//        abq.offer("bbb");
//        try {
//            abq.put("ccc");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        String peek = abq.peek();
//        System.out.println(peek);
//        String poll = abq.poll();
//        System.out.println(poll);
//        System.out.println(abq.size());


        HashMap<String,String> hm = new HashMap<>();
        hm.keySet();

        TreeMap<String,String> tm = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        tm.put("aaa","bbb");



        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
    }

    public static void main(String[] args) {
        sa();

    }

    public static void sb(){
        ThreadPoolExecutor executorService =
                new ThreadPoolExecutor(2, 5, 0L,
                        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10));

        IntStream.rangeClosed(1, 10).forEach(i->{
            executorService.execute(()->{
                try {
                    System.out.println(i+"==任务");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i+"结束");
            });
        });
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
//        executorService.shutdown();
    }


    public static   void sa(){
        Thread thread = new Thread(() -> {
            System.out.println("开始");
            try {
                if (Thread.currentThread().isInterrupted()) {
                    TimeUnit.SECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // 设置事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        thread.interrupt();
    }





}
