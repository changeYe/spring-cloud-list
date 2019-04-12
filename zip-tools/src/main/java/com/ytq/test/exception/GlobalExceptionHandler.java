package com.ytq.test.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuantongqin
 * 2019/4/10
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String handlerException(BindException e){
        System.out.println(e.getMessage());
        return e.getAllErrors().get(0).getDefaultMessage();
    }

}
