package com.novante.todorestapi.services;

import com.novante.todorestapi.entities.TodoList;
import com.novante.todorestapi.repositories.TodoListRepository;
import com.novante.todorestapi.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoListRepository todoListRepository;

    public TodoService(TodoRepository todoRepository, TodoListRepository todoListRepository) {
        this.todoRepository = todoRepository;
        this.todoListRepository = todoListRepository;
    }




//    public TodoList createTodoList(TodoList todoList, Long userId) {
//
//    }

    public List<TodoList> getAllTodoLists(Long userId) {
        return todoListRepository.findTodoListsByUser_UserId(userId);
    }


//    public Todo createTodoItem(Todo todo) {
//        todoRepository.save(todo);
//        return todo;
//    }
//
//    public List<Todo> getAllTodoItemsByUserId() {
//        todoRepository
//    }
}
