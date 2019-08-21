package com.ytq.m.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author yuantongqin
 * 2019/8/1
 */

public class Ta {

    @JSONField
    private String sname;

    private String saddr;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }
}
