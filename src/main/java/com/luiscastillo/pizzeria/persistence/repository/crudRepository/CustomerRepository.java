package com.luiscastillo.pizzeria.persistence.repository.crudRepository;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity,String> {
    List<CustomerEntity> findByNameContainingIgnoreCase(String name);
}
