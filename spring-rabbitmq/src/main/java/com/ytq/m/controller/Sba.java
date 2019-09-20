package com.ytq.m.controller;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuantongqin
 * 2019/8/28
 */
public class Sba implements Serializable {

    private List<String>  sas;

    public List<String> getSas() {
        return sas;
    }

    public void setSas(List<String> sas) {
        this.sas = sas;
    }
}
