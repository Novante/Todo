package com.novante.todorestapi.repositories;

import com.novante.todorestapi.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



}
