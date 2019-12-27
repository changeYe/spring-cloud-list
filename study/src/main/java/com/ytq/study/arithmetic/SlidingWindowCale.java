package com.ytq.study.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuantongqin
 * description: 数组滑动窗口计算窗口中的最大值
 * 2019/12/7
 */
public class SlidingWindowCale {

    static int[] nums = {1, 2, 5, -1, 6, 26, 7, 3, -5, 0, 44, 9, 12};

    public static void main(String[] args) {
        bruteForce(3);
    }

    public static void maxSlidingWindow1() {

    }


    /**
     * 暴力解决方法
     * 数组的长度为N,取k个数中的最大值,需要将数组分成N-k+1 段,取出每段中的最大值,保存到一个集合中;
     * 集合要遍历整个数组,然后在K个元素中去最大值,时间复杂度O(Nk)
     */
    public static void bruteForce(int k) {
        List<Integer> result = new ArrayList<>(nums.length - k + 1);
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = 0;
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            result.add(max);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

}
