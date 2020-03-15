package com.ytq.data.config.valid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuantongqin
 * description:
 * 2020/3/12
 */
public class ISBResult<T> {

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    /**
     * 服务器处理的验证信息(包含所有验证失败的出错字段).
     */
//    @ApiModelProperty(value = "服务处理的返回值", name = "服务处理的返回值", example = "{ \"name\":\"张三\", \"age\":24}")
    private List<ISBFieldError> validationErrors = new ArrayList<ISBFieldError>();


    public List<ISBFieldError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ISBFieldError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
