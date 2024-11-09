package com.luiscastillo.pizzeria.persistence.repository.crudRepository;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import com.luiscastillo.pizzeria.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

    @Query(value = """
                select  po.id_order as IdOrder,
                        c.name as CustomerName,
                        po.date as OrderDate,
                        po.total as OrderTotal,
                        GROUP_CONCAT(p.name) as PizzaNames
                from pizza_order po 
                    inner join pizzeria.customer c on po.id_customer = c.id_customer 
                    inner join pizzeria.order_item oi on po.id_order = oi.id_order 
                    inner join pizzeria.pizza p on oi.id_pizza = p.id_pizza 
                where po.id_order= :orderId 
                group by po.id_order, c.name, po.date, po.total;
            """
            , nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") int orderId);

    @Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("idCustomer") String idCustomer,@Param("method") String method);
}
