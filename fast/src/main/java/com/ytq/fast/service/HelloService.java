package com.ytq.fast.service;

import com.ytq.fast.entity.User;
import com.ytq.fast.event.ApplicationEventDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
@Service
public class HelloService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Transactional(rollbackFor = Exception.class)
    public void testHello(String name){

        sendEvent(name);

    }

    @Transactional
    public void ss(){

    }

    @TransactionalEventListener
    public void sendEvent(String name){
        User u = new User();
        u.setName(name);
        applicationEventPublisher.publishEvent(u);

        applicationEventPublisher.publishEvent(new ApplicationEventDemo(name));

    }
}
