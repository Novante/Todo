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
        todo.setTodoList(foundTodoList);
        todoRepository.save(todo);
        todoListRepository.save(foundTodoList);

        return todo;
    }

    public List<Todo> getAllTodoListItemsByListIdAndUserId(Long todoListId, Long userId) {
        List<Todo> foundTodos = todoRepository.findTodosByTodoList_TodoListIdAndTodoList_User_UserId(todoListId, userId);
        return foundTodos;
    }

    public Todo modifyTodoItem(Todo todoItem, Long userId) {
        Todo foundTodoItem = todoRepository.findTodoByTodoIdAndTodoList_User_UserId(todoItem.getTodoId(), userId);

        if (todoItem.getTodoName() != null) {
            foundTodoItem.setTodoName(todoItem.getTodoName());
        }
        if (todoItem.getTodoContent() != null) {
            foundTodoItem.setTodoContent(todoItem.getTodoContent());
        }

        todoRepository.save(foundTodoItem);
        return foundTodoItem;
    }

    public String deleteTodoItem(Long todoItemId, Long userId) {
        Todo foundTodoItem = todoRepository.findTodoByTodoIdAndTodoList_User_UserId(todoItemId, userId);
        foundTodoItem.getTodoList().getTodoItems().remove(foundTodoItem);
        todoRepository.delete(foundTodoItem);
        return "Successfully deleted TodoItem with id: " + todoItemId;
    }

}
