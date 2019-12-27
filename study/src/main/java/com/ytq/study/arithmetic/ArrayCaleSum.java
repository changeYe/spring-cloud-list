package com.ytq.study.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yuantongqin
 * 2019/11/23
 * 两个数相加,双重for循环,单循环+set集合
 * 三个数相加,三重for循环,双重for+set集合,先排序+双重for循环
 */
public class ArrayCaleSum {

    public static void main(String[] args) {

//        strAdd();
//        strAddFor();
        String s = "(){}[]";
        String g = "((([})))";
        final boolean valid = valid(g);
        System.out.println(valid);

    }



    /**
     * @param s
     * @return
     */
    public static boolean valid(String s) {

        Stack<Character> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put('}', '{');
        maps.put(']', '[');
        for (int i = 0; i < chars.length; i++) {
            final char aChar = chars[i];
            // 去上一个元素与之匹配,去上一个元素最好的结构就是栈stack
            if (!maps.containsKey(aChar)) {
                stack.push(aChar);
            } else if (stack.size() > 0 && !stack.pop().equals(maps.get(aChar))) {
                return false;
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * 判断数组中相加等于9 的值
     * @return
     */
    public static int[] strAdd() {
        int a = 9;
        int[] ints = {2, 3, 6, 7, 9, 22, 31};
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            Integer map = maps.get(a - anInt);
            if (map != null) {
                return new int[]{anInt, map};
            } else {
                maps.put(anInt, anInt);
            }

        }
        return new int[]{};
    }

    public static int[] strAddFor() {
        int a = 9;
        int[] ints = {2, 3, 6, 7, 9, 22, 31};
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + i; j < ints.length; j++) {
                if (ints[i] + ints[j] == a) {
                    return new int[]{ints[i], ints[j]};
                }
            }
        }
        return new int[]{};
    }

}
