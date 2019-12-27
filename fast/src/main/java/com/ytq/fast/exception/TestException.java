package com.ytq.fast.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuantongqin
 * description:
 * 2019/12/22
 */
@ControllerAdvice(basePackages = "com.ytq.fast")
@Slf4j
public class TestException {

    @ExceptionHandler(value = {FastException.class})
    @ResponseBody
    public FastResult handlerFastException(FastException e){

        log.warn("异常:",e);
        return null;
    }
}
