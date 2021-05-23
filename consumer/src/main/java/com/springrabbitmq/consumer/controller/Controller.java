package com.springrabbitmq.consumer.controller;

import com.springrabbitmq.consumer.model.CustomMessageModel;
import com.springrabbitmq.consumer.service.ConfigurationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@Component
public class Controller {

    @RabbitListener(queues = ConfigurationService.QUEUE)
    public  String receiveMessage( CustomMessageModel message){
            System.out.println("Hello This program will read message from RabbitMQ. ");
            System.out.println(message);
        return  "Your message is published to RabbitMQ.";
    }
}
