package com.algorithm.list.array;

/**
 * @author yuantongqin
 * 2019/7/31
 */
public class Array {

    private int[] data;

    private int size;

    public Array(int capacity){
        data = new int[capacity];
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }


}
