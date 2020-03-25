package com.ytq.fault.hundred.pool;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yuantongqin
 * description:
 * 2020/3/17
 */
public class CustomBlockingQueue<E> extends ArrayBlockingQueue<E> {


    public CustomBlockingQueue(int capacity) {
        super(capacity);
    }

    public CustomBlockingQueue(int capacity, boolean fair) {
        super(capacity, fair);
    }

    public CustomBlockingQueue(int capacity, boolean fair, Collection<? extends E> c) {
        super(capacity, fair, c);

    }
    private static void checkNotNull(Object v) {
        if (v == null){
            throw new NullPointerException();
        }
    }

    public  int  flag = 1;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean offer(E e) {
        // 这里不让添加到队列，而是创建非核心线程
//        if(flag == 1){
//            return false;
//        }
//
//        return super.offer(e);

        // 思想比设置参数巧妙，先允许添加一个
        if (size() == 0) {
            return super.offer(e);
        } else {
            return false;
        }
    }
}
