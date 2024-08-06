package com.anz.rabbitmqspringboot.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitmqconfig {
    @Bean
    public Queue queue()
    {
        return  new Queue("exampleq");
    }
    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange("exampleex");
    }
    @Bean
    public Binding binding()
    {
    return BindingBuilder.bind(queue()).to(exchange()).with("routingkey");
    }
}
