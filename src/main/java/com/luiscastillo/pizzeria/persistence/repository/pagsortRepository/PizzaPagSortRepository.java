package com.luiscastillo.pizzeria.persistence.repository.pagsortRepository;

import com.luiscastillo.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity,Integer> {
    Page<PizzaEntity> findAllByAvailableTrue(Pageable pageable);
}
