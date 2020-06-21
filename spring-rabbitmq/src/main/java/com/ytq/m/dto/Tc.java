package com.ytq.m.dto;

import org.springframework.context.annotation.Bean;

/**
 * @author yuantongqin
 * description:
 * 2020/4/15
 */
public abstract class Tc  {

    /**
     * 订单延迟队列（死信队列）
     */

    @Bean
    public void sa(){


        BasicQueue basicQueue = getBasicQueue();
        if(basicQueue == null){
            throw new RuntimeException("不能为空");
        }

    }

    public abstract BasicQueue getBasicQueue();

    public static void main(String[] args) {
        int a  = 128;
        Integer integer = 128;
        System.out.println(a == integer);

//        Executors.newWorkStealingPool();


    }
}
