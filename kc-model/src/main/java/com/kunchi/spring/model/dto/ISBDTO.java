package com.kunchi.spring.model.dto;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ISB 数据传输对象", description = "用来传递对象")
public class ISBDTO<I> implements Serializable {

    private I id = null;

    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty("创建时间")
    private Long createDate;
    @ApiModelProperty("修改人")
    private String updateBy;
    @ApiModelProperty("修改时间")
    private Long updateDate;


    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "ISBDTO{" +
               "id=" + id +
               ", createBy='" + createBy + '\'' +
               ", createDate=" + createDate +
               ", updateBy='" + updateBy + '\'' +
               ", updateDate=" + updateDate +
               '}';
    }
}
