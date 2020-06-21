package com.ytq.m.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuantongqin
 * 2019/7/31
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class HelloDTO extends Ta{

    @NotNull(message = "名称")
    private String name;

    @NotBlank(message = "地址不能为空")
    private String address;

    private int age;

    private String phone;

    @NotNull
    private Tb item;



}
