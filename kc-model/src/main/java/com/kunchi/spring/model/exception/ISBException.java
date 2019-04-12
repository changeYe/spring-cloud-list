package com.kunchi.spring.model.exception;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * yuantongqin
 * 2019/3/4
 */
@ApiModel(value = "ISB 异常类处理",description = "包含异常编码，类型，信息，错误堆栈")
public class ISBException extends RuntimeException {

    public ISBException(String message){
        super(message);
        this.errorCode = ExceptionConstant.ISB_ERROR_CODE;
        this.message = message;
    }

    public ISBException(String errorCode,String message){
        super(message);
        this.errorCode = errorCode;
    }

    public ISBException(String errorCode,String message,List<String> messageStacks){
        super(message);
        this.errorCode = errorCode;
        if(messageStacks != null){
            this.messageStacks = messageStacks;
        }
        boolean isTrue = this.messageStacks.contains(message);
        if(!isTrue){
            this.messageStacks.add(0,message);
        }
    }

    public ISBException(String errorCode,String message,Throwable t){
        super(message,t);
        this.errorCode = errorCode;
        this.message = message;
        if (t != null) {
            this.errorStacks = ExceptionUtils.getStackTrace(t);
        }

    }

    @ApiModelProperty("异常编码")
    private String errorCode;
    @ApiModelProperty("异常信息")
    private String message;
    @ApiModelProperty("异常堆栈")
    private String errorStacks;
    @ApiModelProperty("跟踪异常堆栈")
    private List<String> messageStacks;

    public String getErrorCode() {
        return errorCode;
    }

    public List<String> getMessageStacks() {
        return messageStacks;
    }
}
