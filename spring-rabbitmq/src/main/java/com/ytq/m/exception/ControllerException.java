package com.ytq.m.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuantongqin
 * 2019/7/31
 */
@ControllerAdvice
public class ControllerException {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerException.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     */
    @InitBinder
    public void initData(WebDataBinder binder){
        LOGGER.info("binder.getFieldDefaultPrefix {}",binder.getFieldDefaultPrefix());
        LOGGER.info("binder.getFieldMarkerPrefix {}",binder.getFieldMarkerPrefix());
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "harry");
    }

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    String handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error("验证错误:"+e.getMessage(), e);
        String msg = "验证错误:"+e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return msg;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    String handleMethodArgument(BindException e){
        LOGGER.error("数据并单错误:"+e.getMessage(), e);
        String msg = "" + e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return msg;
    }

    @ExceptionHandler(Exception.class)
    void handleMethodException(Exception e){
        LOGGER.error("exception 异常:"+e.getMessage(), e);
    }





}
