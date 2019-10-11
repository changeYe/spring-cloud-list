package com.ytq.m.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import java.util.List;

import com.alibaba.fastjson.parser.ParserConfig;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * @author yuantongqin
 * 2019/8/1
 */

public class Tb {

        @Data
        public static class Param{

                @NotBlank
                private String sname;

                @NotNull
                private int sage;
        }

        public static void main(String[] args) {
//               User user = new User().setName("").setAge(10);
        }



}
