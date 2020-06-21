package com.ytq.fault.hundred.exception;

/**
 * @author yuantongqin
 * description:
 * 2020/4/8
 */
public class HundredException {

    public static BusinessException b = new BusinessException("没有了");

    public static BusinessException a(){
        return new BusinessException("hym");
    }

}
