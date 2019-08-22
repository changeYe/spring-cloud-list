package com.ytq.m.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/8/22
 */
@Component
@RabbitListener(queues = {"topicQueue"})
public class TopicConsumer {


    @RabbitHandler
    public void process(String msg){
        System.out.println("TopicConsumer:"+msg);
    }

}
