package com.ytq.m.config;

import java.util.function.BiConsumer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/9/23
 *
 */
@Component
public class InitAware implements ApplicationContextAware{

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("name =="+name);
        }
    }

    public void sayHello(){
        System.out.println("hello world");

         BiConsumer s = new BiConsumer() {
             @Override
             public void accept(Object o, Object o2) {

             }
         };
    }
}
