package com.ytq.data.service;

import com.ytq.data.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/30
 */
@Component
public class Taa implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.getName()+"==name");
    }
}
