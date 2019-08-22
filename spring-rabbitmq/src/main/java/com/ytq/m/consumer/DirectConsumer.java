package com.ytq.m.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/8/22
 */
@Component
@RabbitListener(queues = {"directQueue"})
public class DirectConsumer {


    @RabbitHandler
    public void process(String msg){
        System.out.println("directConsumer:"+msg);
    }

}
