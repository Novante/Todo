package com.novante.todorestapi.controllers;

import com.novante.todorestapi.entities.Todo;
import com.novante.todorestapi.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoitem")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/listId/{listId}/userId/{userId}")
    public List<Todo> getAllTodoListItemsByListIdAndUserId(@PathVariable Long listId, @PathVariable Long userId) {
        return todoService.getAllTodoListItemsByListIdAndUserId(listId, userId);
    }

    @PostMapping("/listId/{listId}/userId/{userId}")
    public Todo createTodoItem(@RequestBody Todo todoItem, @PathVariable Long listId, @PathVariable Long userId) {
        return todoService.createTodoItem(todoItem, listId, userId);
    }

    @PatchMapping("/userId/{userId}")
    public Todo modifyTodoItem(@RequestBody Todo todoItem, @PathVariable Long userId) {
        return todoService.modifyTodoItem(todoItem, userId);
    }


}
