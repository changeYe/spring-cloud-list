package com.ytq.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/30
 */
@Component
@Data
public class User {

    private Integer id;
    private String name = "张三";
    private String password;

}
