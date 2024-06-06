package com.codekerki.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codekerki.redis.service.MessagePublisher;

@RestController
@RequestMapping("/api/v1/")
public class PubSubController {
    
    @Autowired
    MessagePublisher publisher;

    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
        publisher.publishMessage(message);
        return "Message published: " + message;
    }
}
