package com.ytq.m.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/8/22
 */
@Component
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        rabbitTemplate.convertAndSend("direct_exchange","routingDirect","直连交换机发送的消息");
        rabbitTemplate.convertAndSend("topic_exchange","routingTopic.a","主题交换机发送的消息");
        rabbitTemplate.convertAndSend("fanout_exchange","","广播交换机发送的消息1");
//        rabbitTemplate.convertAndSend("fanout_exchange","","广播交换机发送的消息2");

    }

}
