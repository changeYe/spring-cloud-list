package com.ytq.study.multithread.thread.chm;


import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuantongqin
 * description:
 * 2019/12/17
 */
public class CHMapDemo {

    /**
     * >>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
     * >>>：无符号右移。无论是正数还是负数，高位通通补0。
     */

    public static void main(String[] args) {

        // 通过工具实现并发安全
//        Collections.synchronizedCollection()
        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>();
//        Spring bean 中使用chm
        for (int i = 10; i <= 30; i++) {
            if(i==15){
                chm.put("a","yiyang");
            }else{
                chm.put(""+ i, "a" + i);
            }

        }
        Character  a = 'a';
        int i = a.hashCode();
        System.out.println("aa="+i);

        chm.size();

//        chm.put("88","张三");
//
//        chm.get("88");

//        com.ytq.study.multithread.thread.ConcurrentHashMap<String,String> s = new com.ytq.study.multithread.thread.ConcurrentHashMap<>();
//        s.put("11","李四");
//        s.get("11");
//        s.size();
//        1100001
//           1111
//        11000100001
//               1111

        // 10000
//        String sa = Integer.toBinaryString(16);
//        System.out.println(sa);
//        String s1 = Integer.valueOf("100", 2).toString();
//        System.out.println(s1);
//
//        int n = 16;
//        System.out.println(n >>>2 );
//
//
//        Integer.numberOfLeadingZeros(16);

    }

}
