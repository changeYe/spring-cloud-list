package com.kunchi.guava;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * yuantongqin
 * 2019/3/21
 */
public class Test {

    static final int HASH_BITS = 0x7fffffff;
    public static void main(String[] args) {

        // 这个api 可以将一个
//        Collections.synchronizedCollection()
//
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("key","value");
        map.size();

//
        HashMap hashMap = new HashMap();
        hashMap.put("","");
        int a =9;
        System.out.println(8&1);


        // 线程安全的随机数
        ThreadLocalRandom.current();
        String key = "1234";
        int h ;

        int aa = 128 << 2;
        int aaa = 2 << 15;
        System.out.println(aaa);
        System.out.println(aa+"==aa");
        System.out.println(key.hashCode()+"==hahs");
        System.out.println(key.hashCode() >>> 16);
//        101110000100001000010
//                        10111

        int hashmap = (h = key.hashCode()) ^ (h >>> 16);
        int chm = (h ^ (h >>> 16)) & HASH_BITS;
        System.out.println(HASH_BITS);
        System.out.println(hashmap);
        System.out.println(chm);
        String l = "1111111111111111111111111111111";
        String l1 = "101110000100001000010";
        System.out.println(l1.length());
        System.out.println(l.length());


    }

}

