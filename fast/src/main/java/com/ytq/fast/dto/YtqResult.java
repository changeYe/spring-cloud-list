package com.ytq.fast.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
@Data
@Accessors(chain = true)
public class YtqResult<T> {

    private Integer code;
    private String message;
    private T body;

}
