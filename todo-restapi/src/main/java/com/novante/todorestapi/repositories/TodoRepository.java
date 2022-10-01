package com.novante.todorestapi.repositories;

import com.novante.todorestapi.entities.Todo;
import com.novante.todorestapi.entities.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
