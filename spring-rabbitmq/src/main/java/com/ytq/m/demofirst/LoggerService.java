package com.ytq.m.demofirst;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yuantongqin
 * 2019/9/22
 */
public class LoggerService implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 通过我们的条件动态注入我们需要的bean,而不是笼统的将所有的bean都注入进入
        Class clazz = LoggerService.class;
        RootBeanDefinition logger = new RootBeanDefinition(clazz);
        String beanName = clazz.getSimpleName();
        beanDefinitionRegistry.registerBeanDefinition(beanName,logger);
    }
}
