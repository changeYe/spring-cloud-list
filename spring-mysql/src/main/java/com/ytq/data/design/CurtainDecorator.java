package com.ytq.data.design;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuantongqin
 * 2019/10/28
 */
@Component
public class CurtainDecorator extends BaseDecorator {


    public CurtainDecorator(@Qualifier("decorator") IDecorator decorator) {
        super(decorator);
    }

    /**
     * 窗帘具体装饰方法
     */
    @Override
    public void decorate() {
        System.out.println(" 窗帘装饰。。。");
        super.decorate();
    }


}
