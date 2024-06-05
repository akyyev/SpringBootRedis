package com.codekerki.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekerki.redis.model.User;
import com.codekerki.redis.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    
    @Autowired
    UserService handler;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        return handler.getUser(id);
    }

    @DeleteMapping("/{id}")
    public boolean deletUser(@PathVariable("id") String id) {
        return handler.deleteUser(id);
    }

    @PostMapping("/save")
    public void createUser(@RequestBody User user) {
        handler.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return handler.getAllUsers();
    }

}
