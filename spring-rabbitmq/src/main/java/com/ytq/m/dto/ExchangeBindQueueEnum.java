package com.ytq.m.dto;

import lombok.Getter;

/**
 * @author yuantongqin
 * description:
 * 2020/4/12
 */
@Getter
public enum ExchangeBindQueueEnum {
    /**
     * 消息通知ttl队列
     */
    TTL_MESSAGE_QUEUE("order_exchange_ttl","order_queue_ttl","orderKey"),
    ;

    private String exchangeName;

    private String queueName;

    private String routingKeyName;

    ExchangeBindQueueEnum(String exchangeName, String queueName, String routingKeyName) {
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        this.routingKeyName = routingKeyName;
    }
}
