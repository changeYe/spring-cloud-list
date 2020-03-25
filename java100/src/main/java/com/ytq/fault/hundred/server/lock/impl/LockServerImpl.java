package com.ytq.fault.hundred.server.lock.impl;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuantongqin
 * description:
 * 2020/3/22
 */
public class LockServerImpl {

    public static int count = 0;


    public static int reset(){
        count = 0;
        return count;
    }

    public synchronized void wrongLock(){
        synchronized (LockServerImpl.this){
            count ++ ;
        }
    }

    public void reduceRepository(){
        // 同时减少三个商品的库存
        // 1.获取三个商品编码的锁


    }

    public static void main(String[] args) {
        ConcurrentHashMap<Long,String> chm = new ConcurrentHashMap<>(16);
        chm.put(1L,"张三");
        Long id = 10L;
        chm.computeIfAbsent(id, aLong -> {
            System.out.println(aLong);
            return null;
        });
        System.out.println(chm.size());

    }
}
