package com.ytq.fast.exception;

import lombok.Data;

/**
 * @author yuantongqin
 * description:
 * 2019/12/22
 */
public class FastException extends RuntimeException {

    private String code;

    private String msg;

    public FastException(String message) {
        super(message);
    }
}
