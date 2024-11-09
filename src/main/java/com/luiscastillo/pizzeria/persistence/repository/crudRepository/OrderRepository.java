package com.luiscastillo.pizzeria.persistence.repository.crudRepository;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository  extends ListCrudRepository<OrderEntity, Integer>
{
    @Query(value =
            "Select * " +
                    "from pizza_order " +
                    "where id_customer= :id",
            nativeQuery = true
    )
    List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);
}
