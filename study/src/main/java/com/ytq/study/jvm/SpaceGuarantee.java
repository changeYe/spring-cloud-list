package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * 2019/11/22
 *
 */
public class SpaceGuarantee {

    public static void main(String[] args) {
        Byte[] b1 = new Byte[2*1024*1024];
        Byte[] b2 = new Byte[2*1024*1024];
        Byte[] b3 = new Byte[2*1024*1024];
        Byte[] b4 = new Byte[5*1024*1024];

        System.gc();

    }

}
