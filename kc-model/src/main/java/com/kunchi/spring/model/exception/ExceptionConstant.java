package com.kunchi.spring.model.exception;

/**
 * yuantongqin
 * 2019/3/4
 * 异常常量，分为三种情况
 */
public class ExceptionConstant {

    /**
     * 未知异常
     */
    public final static  String UNKOWN_ERROR_CODE = "0";

    /**
     * isb 内部错误
     */
    public final static String ISB_ERROR_CODE = "1";

    /**
     * 服务内部抛出异常，内部拒绝
     */
    public final static String REJECT_ERROR_CODE = "2";

}
