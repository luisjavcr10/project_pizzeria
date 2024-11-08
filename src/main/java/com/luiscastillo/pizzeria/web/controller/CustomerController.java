package com.luiscastillo.pizzeria.web.controller;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import com.luiscastillo.pizzeria.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAll(){
        return ResponseEntity.ok(this.customerService.getAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomerEntity>> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.customerService.getByName(name));
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerEntity> getById(@PathVariable String idCustomer){
        return ResponseEntity.ok(this.customerService.getById(idCustomer));
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
}
