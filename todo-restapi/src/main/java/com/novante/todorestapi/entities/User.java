package com.novante.todorestapi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<TodoList> todoLists;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoList> getTodoLists() {
        return todoLists;
    }

    public void setTodoLists(List<TodoList> todoLists) {
        this.todoLists = todoLists;
    }
}
