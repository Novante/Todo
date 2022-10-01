package com.novante.todorestapi.services;

import com.novante.todorestapi.entities.Todo;
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

    public Todo createTodoItem(Todo todo, Long listId, Long userId) {
        TodoList foundTodoList = todoListRepository.findTodoListByTodoListIdAndUser_UserId(listId, userId);
        foundTodoList.getTodoItems().add(todo);
        todoRepository.save(todo);
        todoListRepository.save(foundTodoList);

        return todo;
    }

    public List<Todo> getAllTodoListItemsByListIdAndUserId(Long todoListId, Long userId) {
        List<Todo> foundTodos = todoRepository.findTodosByTodoList_TodoListIdAndTodoList_User_UserId(todoListId, userId);
        return foundTodos;
    }

}
