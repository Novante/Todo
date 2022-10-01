package com.novante.todorestapi.services;

import com.novante.todorestapi.entities.TodoEntity;
import com.novante.todorestapi.repositories.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public TodoEntity createTodo(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
        return todoEntity;
    }
}
