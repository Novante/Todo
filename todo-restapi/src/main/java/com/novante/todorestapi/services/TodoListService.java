package com.novante.todorestapi.services;

import com.novante.todorestapi.entities.TodoList;
import com.novante.todorestapi.entities.User;
import com.novante.todorestapi.repositories.TodoListRepository;
import com.novante.todorestapi.repositories.TodoRepository;
import com.novante.todorestapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;

    public TodoListService(TodoRepository todoRepository, TodoListRepository todoListRepository, UserRepository userRepository) {
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }

    public TodoList createTodoList(TodoList todoList, Long userId) {
        Optional<User> foundUser = userRepository.findById(userId);

        if (foundUser.isPresent()){
            foundUser.get().getTodoLists().add(todoList);
            todoList.setUser(foundUser.get());
            todoListRepository.save(todoList);
            userRepository.save(foundUser.get());
        }
        return todoList;
    }

    public List<TodoList> getAllTodoLists(Long userId) {
        return todoListRepository.findTodoListsByUser_UserId(userId);
    }

    public TodoList modifyTodoList(TodoList todoList, Long userId) {
        TodoList foundTodoList = todoListRepository.findTodoListByTodoListIdAndUser_UserId(todoList.getTodoListId(), userId);

            if (foundTodoList.getTodoListName() != null){
                foundTodoList.setTodoListName(todoList.getTodoListName());
                todoListRepository.save(foundTodoList);
            }

        return foundTodoList;
    }

    public String deleteTodoList(Long todoListId, Long userId) {
        TodoList foundTodoList = todoListRepository.findTodoListByTodoListIdAndUser_UserId(todoListId, userId);
        Optional<User> foundUser = userRepository.findById(userId);
        foundUser.get().getTodoLists().remove(foundTodoList);
        todoListRepository.delete(foundTodoList);
        return "Successfully deleted Todo-list with id: " + todoListId;
    }
}
