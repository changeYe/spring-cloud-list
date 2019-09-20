package com.ytq.m.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import com.alibaba.fastjson.parser.ParserConfig;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * @author yuantongqin
 * 2019/8/1
 */
@Data
@Validated(Default.class)
public class Tb {

        @NotBlank
        private String sname;

        @NotNull
        private int sage;

}
