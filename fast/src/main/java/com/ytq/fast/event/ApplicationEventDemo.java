package com.ytq.fast.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yuantongqin
 * description:
 * 2019/12/13
 */
public class ApplicationEventDemo<T> extends ApplicationEvent {

    private T t;
    public ApplicationEventDemo(T source) {
        super(source);
        this.t=source;
        System.out.println("这里米娜处理:"+source.toString());
    }

    @Override
    public Object getSource() {
        return t;
    }
}
