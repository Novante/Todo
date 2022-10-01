package com.novante.todorestapi.controllers;

import com.novante.todorestapi.entities.User;
import com.novante.todorestapi.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userId/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }



}
