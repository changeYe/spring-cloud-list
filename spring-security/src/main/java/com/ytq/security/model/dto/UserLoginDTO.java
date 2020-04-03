package com.ytq.security.model.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yuantongqin
 * description:
 * 2020/4/3
 */
@ApiModel("用户登录")
public class UserLoginDTO {

    @ApiModel("登录参数")
    @Data
    public static class Param{

        @NotBlank(message = "用户名不能为空")
        @ApiModelProperty("用户名")
        private String userName;

        @NotBlank(message = "密码不能为空")
        @ApiModelProperty("密码")
        private String password;
    }

    @ApiModel("登录结果")
    @Data
    @Accessors(chain = true)
    public static class Result{

        @ApiModelProperty("token值")
        private String token;


    }
}
