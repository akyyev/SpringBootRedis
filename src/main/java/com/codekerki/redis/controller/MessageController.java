package com.codekerki.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codekerki.redis.service.MessageConsumer;
import com.codekerki.redis.service.MessageProducer;

@RestController
@RequestMapping("/api/v1/")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @Autowired
    private MessageConsumer consumer;

    @PostMapping("/produce")
    public String produce(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/consume")
    public String consume() {
        String message = consumer.receiveMessage();
        return message != null ? "Message received: " + message : "No messages";
    }
}
