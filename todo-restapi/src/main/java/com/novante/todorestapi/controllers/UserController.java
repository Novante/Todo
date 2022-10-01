package com.novante.todorestapi.controllers;

import com.novante.todorestapi.entities.User;
import com.novante.todorestapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PatchMapping("/userId/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Long userId) {
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("userId/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

}
