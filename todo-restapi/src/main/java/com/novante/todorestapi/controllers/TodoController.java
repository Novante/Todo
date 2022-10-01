package com.novante.todorestapi.controllers;

import com.novante.todorestapi.entities.TodoEntity;
import com.novante.todorestapi.services.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public TodoEntity createTodoEntity(@RequestBody TodoEntity todoEntity){
        return todoService.createTodo(todoEntity);
    }

}
