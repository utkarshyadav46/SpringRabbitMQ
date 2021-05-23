package com.springrabbitmq.producer.controller;

import com.springrabbitmq.producer.model.CustomMessageModel;
import com.springrabbitmq.producer.service.ConfigurationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    public RabbitTemplate rabbitTemplate;
    @PostMapping("/publish")
    public  String publishMessage(@RequestBody CustomMessageModel message){

        message.setMessageDate(new Date());
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessage("Hello");
        rabbitTemplate.convertAndSend(ConfigurationService.EXCHANGE,ConfigurationService.ROUTING_KEY,message);
        return  "Your message is published to RabbitMQ.";
    }
}
