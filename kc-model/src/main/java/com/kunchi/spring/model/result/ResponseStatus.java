package com.kunchi.spring.model.result;

/**
 * yuantongqin
 * 2019/3/4
 * 返回的状态值
 */
public enum ResponseStatus {

    SUCCESS("201","201"),//成功
    REFUSED("203","203"),//拒绝
    FAILED("205","205");//异常

    private String code;
    private String message;

    ResponseStatus(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
