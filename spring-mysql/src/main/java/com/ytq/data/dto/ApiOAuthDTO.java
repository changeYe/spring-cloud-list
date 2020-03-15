package com.ytq.data.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author yuantongqin
 * description:
 * 2020/3/11
 */
public class ApiOAuthDTO {

    @Data
    public static class Param{
        @NotNull(message = "token不能为空")
        private String token;
        @NotNull(message = "用户名不能为空")
        private String userName;
        private Long timestamp;
    }

    @Data
    public static class Result{
        private String message;
    }

}
