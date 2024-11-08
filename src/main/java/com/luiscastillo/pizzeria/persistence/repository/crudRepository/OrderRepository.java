package com.luiscastillo.pizzeria.persistence.repository.crudRepository;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository  extends ListCrudRepository<OrderEntity, Integer>
{
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
    List<OrderEntity> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
