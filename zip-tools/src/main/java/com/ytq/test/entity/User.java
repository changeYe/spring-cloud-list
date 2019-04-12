package com.ytq.test.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author yuantongqin
 * 2019/4/10
 */
public class User {

    @Pattern(regexp = "(web|app)",message = "只有web与app两种平台")
    @NotNull(message = "用户名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
