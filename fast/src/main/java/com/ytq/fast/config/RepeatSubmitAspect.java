package com.ytq.fast.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * description:
 * 2019/12/22
 */
@Component
@Aspect
public class RepeatSubmitAspect {
    final static Logger logger = LoggerFactory.getLogger(RepeatSubmitAspect.class);

    /**
     * 切点处理
     */
    @Pointcut("@annotation(com.ytq.fast.config.RepeatSubmit)")
    public void annotationPointCut(){

    }

    @Around("annotationPointCut()")
    public Object noReSubmit(){
        return null;
    }

    @Before("")
    public void beforeDeal(){}

    @AfterReturning()
    public void afterReturnDeal(){

    }

    @AfterThrowing
    public void afterThrowingDeal(){

    }

    @After("")
    public void afterDeal(){

    }





}
