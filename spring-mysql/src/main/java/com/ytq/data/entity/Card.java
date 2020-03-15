package com.ytq.data.entity;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author yuantongqin
 * 2019/11/5
 */
@Data
public class Card {

    @NotBlank(message = "银行卡不能为空")
    private String bankCard;

}
