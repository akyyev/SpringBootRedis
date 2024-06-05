package com.codekerki.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String QUEUE_NAME = "messageQueue";

    public void sendMessage(String message) {
        redisTemplate.opsForList().leftPush(QUEUE_NAME, message);
    }

}
