package com.ytq.m.dto;

/**
 * @author yuantongqin
 * description:
 * 2020/4/15
 */
public class Td extends Tc {

    @Override
    public BasicQueue getBasicQueue() {
        return BasicQueue.builder().exchangeName("").queueName("").routingKeyName("").build();
    }
}
