package com.luiscastillo.pizzeria.service;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import com.luiscastillo.pizzeria.persistence.repository.crudRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAll(){
        return this.customerRepository.findAll();
    }

    public List<CustomerEntity> getByName(String name) {
        return this.customerRepository.findByNameContainingIgnoreCase(name);
    }

    public CustomerEntity getById(String idCustomer){
        return this.customerRepository.findById(idCustomer).orElse(null);
    }

    public CustomerEntity save(CustomerEntity customer){
        return this.customerRepository.save(customer);
    }

    public boolean exists(String idCustomer){
        return this.customerRepository.existsById(idCustomer);
    }

    public void deleteById(String idCustomer){
        this.customerRepository.deleteById(idCustomer);
    }
}
