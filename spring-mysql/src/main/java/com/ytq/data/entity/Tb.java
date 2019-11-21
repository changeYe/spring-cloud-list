package com.ytq.data.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yuantongqin
 * 2019/11/5
 */
@Data
public class Tb {

    @NotNull(message = "用户名不能为空")
    private String name;

    private Integer id;

    @Valid
    private Ta ta;

}
