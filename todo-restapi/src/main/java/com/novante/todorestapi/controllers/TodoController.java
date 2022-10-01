package com.novante.todorestapi.controllers;

import com.novante.todorestapi.entities.Todo;
import com.novante.todorestapi.entities.TodoList;
import com.novante.todorestapi.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/list/{userId}")
    public TodoList createTodoList(@RequestBody TodoList todoList, @PathVariable Long userId) {
        return todoService.createTodoList(todoList, userId);
    }

    @GetMapping("/list/{userId}")
    public List<TodoList> getAllTodoLists(@PathVariable Long userId) {
        return todoService.getAllTodoLists(userId);
    }

    @PatchMapping("/list/{userId}")
    public TodoList modifyTodoList(@RequestBody TodoList todoList, @PathVariable Long userId){
        return todoService.modifyTodoList(todoList, userId);
    }


//    @PostMapping("/item")
//    public Todo createTodoItem(@RequestBody Todo todo){
//        return todoService.createTodoItem(todo);
//    }
//
//    @GetMapping("/items")
//    public List<Todo> getAllTodoItemsByUserId(){
//        return todoService.getAllTodoItemsByUserId();
//    }
}
