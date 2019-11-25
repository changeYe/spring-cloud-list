package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * 2019/11/22
 */
public class StackAllocation {

    public static void main(String[] args) {

//        Byte[] bytes = new Byte[1*1024*1024];
        // -XX:+DoEscapeAnalysis
        StackAllocation stack = new StackAllocation();
        stack.ss();
        System.out.println("ss");
    }

    public void ss(){
//        Byte[] bytes = new Byte[50* 1024];
        String[] s = new String[10];
    }

}
