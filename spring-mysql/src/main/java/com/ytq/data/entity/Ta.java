package com.ytq.data.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author yuantongqin
 * 2019/11/5
 */
@Data
public class Ta {

    @NotNull(message = "地址不能为空")
    private String address;

}
