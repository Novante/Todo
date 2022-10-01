package com.novante.todorestapi.repositories;

import com.novante.todorestapi.entities.TodoList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {

    List<TodoList> findTodoListsByUser_UserId(Long userId);

    TodoList findTodoListByTodoListIdAndUser_UserId(Long todoListId, Long userId);
}
