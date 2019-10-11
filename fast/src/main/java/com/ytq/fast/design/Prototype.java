package com.ytq.fast.design;

/**
 * @author yuantongqin
 * 2019/10/8
 */
public class Prototype implements Cloneable {

    @Override
    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
