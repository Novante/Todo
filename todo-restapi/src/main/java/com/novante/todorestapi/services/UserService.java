package com.novante.todorestapi.services;

import com.novante.todorestapi.entities.User;
import com.novante.todorestapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<User> getAllUsers() {
        List<User> foundUsers = userRepository.findAll();
        return foundUsers;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Long userId) {
        User foundUser = userRepository.findById(userId).get();

        if (user.getUsername() != null){
            foundUser.setUsername(user.getUsername());
        }

        if (user.getPassword() != null){
            foundUser.setPassword(user.getPassword());
        }

        if (user.getTodoLists() != null){
            foundUser.setTodoLists(user.getTodoLists());
        }

        return userRepository.save(foundUser);
    }
}
