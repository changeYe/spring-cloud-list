package com.ytq.data.service.impl;

import com.ytq.data.entity.Person;
import com.ytq.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author yuantongqin
 * description:
 * 2020/3/10
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @TransactionalEventListener
    @Override
    public void sendMessage(String src) {
        System.out.println("事物提交之后发送一个消息："+src);
        Person person = new Person();
        person.setId(1L);
        person.setMessage("发送一个消息");
        applicationEventPublisher.publishEvent(person);
    }

    @EventListener(classes = Person.class)
    public void sayHello(Person person){
        System.out.println("内容"+person.toString());
    }


}
