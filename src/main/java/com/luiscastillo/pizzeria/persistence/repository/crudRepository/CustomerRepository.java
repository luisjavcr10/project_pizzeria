package com.luiscastillo.pizzeria.persistence.repository.crudRepository;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity,String> {
    //We use JPQL for being able to manage the queries manually, because sometimes the conventions aren't enough
    @Query(value = "SELECT customer FROM CustomerEntity customer WHERE customer.phone= :phone")
    CustomerEntity findByPhone(String phone);
}
