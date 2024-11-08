package com.luiscastillo.pizzeria.service;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import com.luiscastillo.pizzeria.persistence.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll() {
        //orders.forEach(o -> System.out.println(o.getCustomer().getName()));
        return this.orderRepository.findAll();
    }


}
