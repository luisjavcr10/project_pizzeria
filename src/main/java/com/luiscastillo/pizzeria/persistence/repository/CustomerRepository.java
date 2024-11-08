package com.luiscastillo.pizzeria.persistence.repository;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity,String> {
}
