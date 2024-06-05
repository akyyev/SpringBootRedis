package com.codekerki.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String QUEUE_NAME = "messageQueue";

    public String receiveMessage() {
        return (String) redisTemplate.opsForList().rightPop(QUEUE_NAME);
    }

}
