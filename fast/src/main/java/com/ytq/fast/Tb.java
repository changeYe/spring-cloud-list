package com.ytq.fast;


import com.google.common.base.Optional;

/**
 * @author yuantongqin
 * 2019/10/11
 */
public class Tb {

    public String name="张三王二";
    /**
     * 名字的修改
     * 将名字修改为王二
     * fast/src/main/java/com/ytq/fast/Tb.java
     * fast/src/main/java/com/ytq/fast/Tb.java
     */


    public void sa(){
        Optional<Ta> of = Optional.of(new Ta());
        of.isPresent();
        of.get();
    }
}
