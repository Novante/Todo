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
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, TodoListRepository todoListRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
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


//    public Todo createTodoItem(Todo todo) {
//        todoRepository.save(todo);
//        return todo;
//    }
//
//    public List<Todo> getAllTodoItemsByUserId() {
//        todoRepository
//    }
}
