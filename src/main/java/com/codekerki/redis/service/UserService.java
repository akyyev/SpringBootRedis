package com.codekerki.redis.service;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.codekerki.redis.model.User;

@Service
public class UserService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String USER_KEY_PREFIX = "USER:";

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), user);
    }

    public User getUser(String id) {
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + id);
    }

    public boolean deleteUser(String id) {
        return redisTemplate.delete(USER_KEY_PREFIX + id);
    }

    public List<User> getAllUsers() {
        
        var setOfUserIds = redisTemplate.keys(USER_KEY_PREFIX + "*");
        
        return setOfUserIds
            .stream()
            .map(id-> (User) redisTemplate.opsForValue().get(id))
            .toList();
    }


}
