package com.novante.todorestapi.controllers;

import com.novante.todorestapi.entities.TodoList;
import com.novante.todorestapi.services.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping("/list/userId/{userId}")
    public TodoList createTodoList(@RequestBody TodoList todoList, @PathVariable Long userId) {
        return todoListService.createTodoList(todoList, userId);
    }

    @GetMapping("/listId/userId/{userId}")
    public List<TodoList> getAllTodoLists(@PathVariable Long userId) {
        return todoListService.getAllTodoLists(userId);
    }

    @PatchMapping("/listId/userId/{userId}")
    public TodoList modifyTodoList(@RequestBody TodoList todoList, @PathVariable Long userId){
        return todoListService.modifyTodoList(todoList, userId);
    }

    @DeleteMapping("/listId/{todoListId}/userId/{userId}")
    public String deleteTodoList(@PathVariable Long todoListId, @PathVariable Long userId){
        return todoListService.deleteTodoList(todoListId, userId);
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
