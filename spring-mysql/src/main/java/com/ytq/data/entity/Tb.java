package com.ytq.data.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

import lombok.Data;

/**
 * @author yuantongqin
 * 2019/11/5
 */
@Data
public class Tb {

    @NotNull(message = "用户名称不能为空")
    private String userName;


    @Valid
    @Size(min = 10)
    @NotNull(message = "集合不为空")
    private List<Card> cards;
//    private Ta ta;

}
