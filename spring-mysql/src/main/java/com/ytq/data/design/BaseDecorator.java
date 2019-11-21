package com.ytq.data.design;

/**
 * @author yuantongqin
 * 2019/10/28
 */
public abstract class BaseDecorator implements IDecorator{

    private IDecorator decorator;

    public BaseDecorator(IDecorator decorator) {
        this.decorator = decorator;
    }

    /**
     * 调用装饰方法
     */
    @Override
    public void decorate() {
        if(decorator != null) {
            decorator.decorate();
        }
    }

}
