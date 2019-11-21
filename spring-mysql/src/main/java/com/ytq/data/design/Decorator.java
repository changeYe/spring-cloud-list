package com.ytq.data.design;

import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/28
 */
@Component("decorator")
public class Decorator implements IDecorator{


    @Override
    public void decorate() {
        System.out.println(" 水电装修、天花板以及粉刷墙。。。");
    }

}
