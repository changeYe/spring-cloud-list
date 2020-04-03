package com.ytq.security.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yuantongqin
 * description:
 * 2020/3/30
 */
@ApiModel("用户注册")
public class UserRegisterDTO {

    @Data
    @ApiModel("请求参数")
    public static class Param{
        private String userName;

        private String password;
    }

    @Data
    @ApiModel("返回结果")
    public static class Result{

    }



}
