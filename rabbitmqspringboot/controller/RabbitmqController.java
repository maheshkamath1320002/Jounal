package com.anz.rabbitmqspringboot.controller;

import com.anz.rabbitmqspringboot.producer.Rabbitmqproducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RabbitmqController {
    private Rabbitmqproducer rabbitmqproducer;

    public RabbitmqController(Rabbitmqproducer rabbitmqproducer) {
        this.rabbitmqproducer = rabbitmqproducer;
    }

    @GetMapping
    public void sendmessage(@RequestParam("m") String mesage)
    {
rabbitmqproducer.sendMessage(mesage);
    }
}
