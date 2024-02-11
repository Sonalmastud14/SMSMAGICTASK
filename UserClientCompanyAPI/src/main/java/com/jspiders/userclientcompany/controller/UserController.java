package com.jspiders.userclientcompany.controller;
import org.apache.catalina.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.userclientcompany.repository.UserRepository;

import ch.qos.logback.core.net.server.Client;
import lombok.Data;

import java.util.List;




@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

   
    @GetMapping("/users")
    public List<User> listUsers(@RequestParam(required = false) String username) {
        if (username != null) {
            return userRepository.findByUsernameContaining(username);
        } else {
            return userRepository.findAll();
        }
    }

   
    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        updatedUser.setId(userId); // Ensure the ID from the path is set
        return userRepository.save(updatedUser);
    }
}