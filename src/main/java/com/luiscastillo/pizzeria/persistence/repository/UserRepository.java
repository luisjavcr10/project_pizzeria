package com.luiscastillo.pizzeria.persistence.repository;

import com.luiscastillo.pizzeria.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
