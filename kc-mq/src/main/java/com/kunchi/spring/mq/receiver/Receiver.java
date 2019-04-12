package com.kunchi.spring.mq.receiver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * yuantongqin
 * 2019/3/5
 */
public class Receiver {

    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1:创建连接工厂，创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            //
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        }

    }

}
