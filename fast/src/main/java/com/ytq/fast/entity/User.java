package com.ytq.fast.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;

/**
 * @author yuantongqin
 * 2019/8/1
 */
@Data
public class User {

    private String name;
    private Integer age;
    private String address;

    public void tu(Article article){
//        路捷鲲驰集团
        System.out.println(article.toString());
    }

    @PostConstruct
    public void ss(){
        System.out.println("构造");
    }

    @PreDestroy
    public void ssb(){
        System.out.println("销毁");
    }
}
