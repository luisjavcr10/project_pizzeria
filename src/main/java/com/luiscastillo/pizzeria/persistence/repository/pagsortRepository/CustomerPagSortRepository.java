package com.luiscastillo.pizzeria.persistence.repository.pagsortRepository;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CustomerPagSortRepository extends PagingAndSortingRepository<CustomerEntity,Integer>
{
    Page<CustomerEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
