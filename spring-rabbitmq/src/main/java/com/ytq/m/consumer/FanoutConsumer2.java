package com.ytq.m.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/8/22
 */
@Component
@RabbitListener(queues = {"fanoutQueue1"})
public class FanoutConsumer2 {


    @RabbitHandler
    public void process(String msg){
        System.out.println("FanoutConsumer2:"+msg);
    }

}
