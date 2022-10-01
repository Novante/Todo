package com.novante.todorestapi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todoListId;

    private String todoListName;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Todo> todoItems;

    private Long getTodoListId() {
        return todoListId;
    }

    private void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }

    private String getTodoListName() {
        return todoListName;
    }

    private void setTodoListName(String todoListName) {
        this.todoListName = todoListName;
    }

    private User getUser(){
        return user;
    }

    private void setUser(User user){
        this.user = user;
    }

    private List<Todo> getTodoItems() {
        return todoItems;
    }

    private void setTodoItems(List<Todo> todoItems) {
        this.todoItems = todoItems;
    }
}
