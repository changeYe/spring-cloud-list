package com.ytq.fast.config;

import javax.annotation.PostConstruct;

import io.sentry.Sentry;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * @author yuantongqin
 * description:
 * 2020/3/25
 */
@Configuration
public class SentryConfig {

    @PostConstruct
    public void init(){
        Sentry.init("https://0e977d9bf7534ebb83653f8ade1eea00@sentry.io/5174019");
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new io.sentry.spring.SentryServletContextInitializer();
    }


    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new io.sentry.spring.SentryExceptionResolver();
    }

}
