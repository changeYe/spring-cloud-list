package com.ytq.m.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author yuantongqin
 * description:
 * 2020/4/15
 */
@Data
@Builder
public class BasicQueue {


    private String exchangeName;

    private String queueName;

    private String routingKeyName;

    @Tolerate
    public BasicQueue(){}

}
