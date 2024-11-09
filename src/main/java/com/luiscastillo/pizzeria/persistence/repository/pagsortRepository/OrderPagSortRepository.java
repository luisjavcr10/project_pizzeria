package com.luiscastillo.pizzeria.persistence.repository.pagsortRepository;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderPagSortRepository extends PagingAndSortingRepository<OrderEntity, Integer> {
    Page<OrderEntity> findAllByDateAfter(LocalDateTime date, Pageable pageable);
    Page<OrderEntity> findAllByMethodIn(List<String> methods,Pageable pageable);
    Page<OrderEntity> findByDateBetween(LocalDateTime start, LocalDateTime end,Pageable pageable);
}
