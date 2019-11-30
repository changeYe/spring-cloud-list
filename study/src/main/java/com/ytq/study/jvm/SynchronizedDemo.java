package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * description:
 * 2019/11/29
 */
public class SynchronizedDemo {

    public static void main(String[] args) {

        new  Thread(()->{
            System.out.println("111");
            SynchronizedDemo demo1= new SynchronizedDemo();
            demo1.f1();
        }).start();

        new Thread(()->{
            System.out.println("2222");
            SynchronizedDemo demo2= new SynchronizedDemo();
            demo2.f2();
            demo2.f4();
        }).start();

    }

    public synchronized void f1(){
        try {
            System.out.println("方法f1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void f2(){
        synchronized (this){
            System.out.println("f2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void f3(){
        synchronized (SynchronizedDemo.class){
            try {
                System.out.println("f3");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
    public void f4(){
        synchronized (SynchronizedDemo.class){
            System.out.println("f4");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }




}
