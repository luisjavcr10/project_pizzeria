package com.luiscastillo.pizzeria.service;

import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import com.luiscastillo.pizzeria.persistence.repository.crudRepository.OrderRepository;
import com.luiscastillo.pizzeria.persistence.repository.pagsortRepository.OrderPagSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderPagSortRepository orderPagSortRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderPagSortRepository orderPagSortRepository) {
        this.orderRepository = orderRepository;
        this.orderPagSortRepository = orderPagSortRepository;
    }

    public Page<OrderEntity> getAll(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return this.orderPagSortRepository.findAll(pageRequest);
    }

    public Page<OrderEntity> getTodayOrders(int page, int size) {
        LocalDateTime today= LocalDate.now().atTime(0,0);
        Pageable pageRequest = PageRequest.of(page, size);
        return this.orderPagSortRepository.findAllByDateAfter(today,pageRequest);
    }

    public Page<OrderEntity> getOutsideOrders(int page, int size) {
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        Pageable pageRequest = PageRequest.of(page, size);
        return this.orderPagSortRepository.findAllByMethodIn(methods,pageRequest);
    }

    public Page<OrderEntity> getOrdersPerDates(LocalDateTime start, LocalDateTime end,int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return this.orderPagSortRepository.findByDateBetween(start, end,pageRequest);
    }

    public List<OrderEntity> getCustomerOrders(String idCustomer) {
        return this.orderRepository.findCustomerOrders(idCustomer);
    }

}
