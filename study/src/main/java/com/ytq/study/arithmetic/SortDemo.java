package com.ytq.study.arithmetic;

import java.util.UUID;

/**
 * @author yuantongqin
 * description:
 * 2019/11/27
 */
public class SortDemo {

    public static void main(String[] args) {

        String s = UUID.randomUUID().toString();
        System.out.println(s);



//        insertionSort();
    }

    /**
     * 插入排序，a 表示数组，n 表示数组大小
     */
    public static void insertionSort() {
        //  n= 6
        int[] a = {5, 1, 8, 4, 2, 4, 3};
        for (int i = 1; i < a.length; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                    int aa = 10;
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }

    public static void sa() {
        int[] s = {5, 1, 8, 4, 2, 4, 3};
        // 从小到大
        for (int i = 0; i < s.length; i++) {
//            int a = s[i];
            for (int j = i + 1; j < s.length; j++) {
//                int b = s[j];
                if (s[i] > s[j]) {
                    int a = s[j];
                    s[j] = s[i];
                    s[i] = a;
//                  a = b;
                }
            }
        }

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

}
