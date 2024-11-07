package com.luiscastillo.pizzeria.persistence.repository;

import com.luiscastillo.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer>
{
}
