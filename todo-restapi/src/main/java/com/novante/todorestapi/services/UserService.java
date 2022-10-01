package com.novante.todorestapi.services;

import com.novante.todorestapi.entities.User;
import com.novante.todorestapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserById(Long userId) {
        Optional<User> foundUser = userRepository.findById(userId);
        return foundUser.get();
    }
}
