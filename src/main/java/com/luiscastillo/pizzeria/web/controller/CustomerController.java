package com.luiscastillo.pizzeria.web.controller;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import com.luiscastillo.pizzeria.persistence.entity.OrderEntity;
import com.luiscastillo.pizzeria.service.CustomerService;
import com.luiscastillo.pizzeria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Page<CustomerEntity>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
    ){
        return ResponseEntity.ok(this.customerService.getAll(page, size, sortBy, sortDirection));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<CustomerEntity>> getByName(
            @PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
    ){
        return ResponseEntity.ok(this.customerService.getByName(name,page,size,sortBy,sortDirection));
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerEntity> getById(@PathVariable String idCustomer){
        return ResponseEntity.ok(this.customerService.getById(idCustomer));
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.getByPhone(phone));
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> add(@RequestBody CustomerEntity customer){
        if(!this.customerService.exists(customer.getIdCustomer())){
            return ResponseEntity.ok(this.customerService.save(customer));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<CustomerEntity> update(@RequestBody CustomerEntity customer){
        if(this.customerService.exists(customer.getIdCustomer())){
            return ResponseEntity.ok(this.customerService.save(customer));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<Void> delete(@PathVariable String idCustomer){
        if(this.customerService.exists(idCustomer)){
            this.customerService.deleteById(idCustomer);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String idCustomer){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(idCustomer));
    }



}
