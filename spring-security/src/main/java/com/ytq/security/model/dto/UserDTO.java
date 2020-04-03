package com.ytq.security.model.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yuantongqin
 * description:
 * 2020/4/3
 */
@ApiModel("用户信息")
public class UserDTO {

    @ApiModel("请求参数")
    @Data
    @Accessors(chain = true)
    public static class Param{
        @ApiModelProperty("用户id")
        @NotEmpty(message = "用户id不能为空")
        private Long userId;
    }

    @ApiModel("结果")
    @Data
    public static class Result{

        private String message;
    }


}
