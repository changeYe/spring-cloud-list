package com.ytq.m.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author yuantongqin
 * 2019/9/30
 */
@Data
@Builder
public class User {

    @NonNull
    private String name;

    private Integer age;

}
