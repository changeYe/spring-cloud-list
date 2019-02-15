package com.kunchi.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 方法 handleException() 就会处理所有 Controller 层抛出的 Exception 及其子类的异常，这是最基本的用法了。
     * 处理不可知的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AppResponse handleExceptionContent(Exception e){
        logger.info(e.getMessage());
        AppResponse response = new AppResponse();
        response.setCode(401);
        response.setMsg("这里是异常的内容"+e.getMessage());
        return response;
    }

    /**
     * 处理所有的业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public AppResponse handleBusinessExceptionContent(BusinessException e){
        logger.error(e.getMessage(),e);
        AppResponse response = new AppResponse();
        response.setCode(500);
        response.setMsg("业务异常："+e.getMessage());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AppResponse handleMethodException(){
        AppResponse response = new AppResponse();
        response.setCode(502);
        response.setMsg("方法参数异常");
        return response;
    }

}
