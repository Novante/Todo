package com.novante.todorestapi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String username;

    private String password;

    @OneToMany
    private List<TodoList> todoLists;

    private Long getUserId() {
        return userId;
    }

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    private String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private List<TodoList> getTodoLists() {
        return todoLists;
    }

    private void setTodoLists(List<TodoList> todoLists) {
        this.todoLists = todoLists;
    }
}
