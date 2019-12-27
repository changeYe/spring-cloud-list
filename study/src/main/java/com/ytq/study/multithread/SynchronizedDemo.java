package com.ytq.study.multithread;

/**
 * @author yuantongqin
 * description:
 * 2019/12/9
 */
public class SynchronizedDemo {

    public static void main(String[] args) {

    }

    public synchronized void sync1(){
        System.out.println("第一种方式");
    }

    public void sync2(){
        synchronized (SynchronizedDemo.this){
            System.out.println("第二种方式");
        }
    }

    public void sync3(){
        synchronized (SynchronizedDemo.class){
            System.out.println("第三种方式");
        }
    }

}
