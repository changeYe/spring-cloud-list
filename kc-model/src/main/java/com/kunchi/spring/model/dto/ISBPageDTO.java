package com.kunchi.spring.model.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * yuantongqin
 * 2019/2/15
 */
@ApiModel(value = "分页参数")
public class ISBPageDTO implements Serializable {

    @ApiModelProperty(value = "页数")
    private  int pageNum;
    @ApiModelProperty("分页大小")
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
