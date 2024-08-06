package com.anz.rabbitmqspringboot.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class Rabbitmqproducer {
    String queue="exampleq";

    String exachange="exampleex";
    private static final Logger LOGGER=LoggerFactory.getLogger(Rabbitmqproducer.class);
    RabbitTemplate rabbitTemplate;

    public Rabbitmqproducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(String message)
    {
        LOGGER.info(String.format("message is sent %s",message));
        rabbitTemplate.convertAndSend(exachange,"routingkey",message);

    }
}
