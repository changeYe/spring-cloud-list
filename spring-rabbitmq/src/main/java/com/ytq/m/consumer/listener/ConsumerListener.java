package com.ytq.m.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.ListenerContainerConsumerFailedEvent;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * description:
 * 2020/3/17
 */
@Slf4j
@Component
public class ConsumerListener implements ApplicationListener<ListenerContainerConsumerFailedEvent> {

    @Override
    public void onApplicationEvent(ListenerContainerConsumerFailedEvent event) {

        SimpleMessageListenerContainer container = (SimpleMessageListenerContainer) event.getSource();
        container.getQueueNames();
    }
}
