package com.luiscastillo.pizzeria.persistence.repository;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository  extends ListCrudRepository<OrderEntity, Integer>
{

}
