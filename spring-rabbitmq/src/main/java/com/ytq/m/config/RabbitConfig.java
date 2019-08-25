package com.ytq.m.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuantongqin
 * 2019/8/22
 */
@Configuration
public class RabbitConfig {


    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange",true,false);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic_exchange",true,false);
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_exchange");
    }

    @Bean
    public Queue directQueue(){
        return new Queue("directQueue",true);
    }

    @Bean
    public Queue topicQueue(){
        return new Queue("topicQueue",true);
    }

    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanoutQueue1");
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanoutQueue2");
    }


    @Bean
    public Binding directBinding(DirectExchange directExchange, @Qualifier("directQueue") Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with("routingDirect");
    }
    @Bean
    public Binding topicBinding(TopicExchange topicExchange, @Qualifier("topicQueue") Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with("routingTopic.*");
    }

    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange, @Qualifier("fanoutQueue1") Queue queue){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange, @Qualifier("fanoutQueue2") Queue queue){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }


}
