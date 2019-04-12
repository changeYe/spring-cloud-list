package com.kunchi.spring.model.po;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ISB标准po 基础的数据库主表参数 选择性继承
 * 这里是公用的属性
 */
@ApiModel(value = "ISB 数据库基础类",description = "基础的数据库主表参数 选择性继承")
public class ISBPO {

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date updateDate;



}
