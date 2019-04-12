package com.kunchi.spring.model.result;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * yuantongqin
 * 2019/3/4
 */
@ApiModel("ISB 服务返回对象的规范DTO，所有ISB的服务均返回此对象.")
public class ISBResult<D> implements Serializable {

    @ApiModelProperty("返回状态，成功返回为success")
    private String status = ResponseStatus.SUCCESS.getMessage();
    @ApiModelProperty("状态码，成功200，使用response中定义的状态码")
    private String code = ResponseStatus.SUCCESS.getCode();
    @ApiModelProperty("返回实体对象")
    private D body;
    @ApiModelProperty("总行数")
    private Integer totalCount;

    /**
     * 成功
     */
    public void markSuccess(){
        this.code = ResponseStatus.SUCCESS.getCode();
        this.status = ResponseStatus.SUCCESS.getMessage();
    }

    /**
     * 成功
     */
    public void markRefused(){
        this.code = ResponseStatus.REFUSED.getCode();
        this.status = ResponseStatus.REFUSED.getMessage();
    }

    /**
     * 成功
     */
    public void markFailed(){
        this.code = ResponseStatus.FAILED.getCode();
        this.status = ResponseStatus.FAILED.getMessage();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public D getBody() {
        return body;
    }

    public void setBody(D body) {
        this.body = body;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
