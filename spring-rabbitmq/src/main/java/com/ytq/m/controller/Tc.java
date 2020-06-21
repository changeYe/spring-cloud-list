package com.ytq.m.controller;

import java.util.concurrent.TimeUnit;

/**
 * @author yuantongqin
 * description:
 * 2020/4/12
 */
public class Tc {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println("不停地干活");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("主线程工作");
        // 设置为守护线程，他守护的是主线程
//        thread.setDaemon(true);
        thread.start();


    }

}
