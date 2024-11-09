package com.luiscastillo.pizzeria.service;

import com.luiscastillo.pizzeria.persistence.entity.CustomerEntity;
import com.luiscastillo.pizzeria.persistence.repository.crudRepository.CustomerRepository;
import com.luiscastillo.pizzeria.persistence.repository.pagsortRepository.CustomerPagSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;
    private final CustomerPagSortRepository customerPagSortRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerPagSortRepository customerPagSortRepository) {
        this.customerRepository = customerRepository;
        this.customerPagSortRepository = customerPagSortRepository;
    }

    public Page<CustomerEntity> getAll(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest= PageRequest.of(page,size,sort);
        return this.customerPagSortRepository.findAll(pageRequest);
    }

    public Page<CustomerEntity> getByName(String name,int page, int size,String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest= PageRequest.of(page,size,sort);
        return this.customerPagSortRepository.findByNameContainingIgnoreCase(name,pageRequest);
    }

    public CustomerEntity getById(String idCustomer){
        return this.customerRepository.findById(idCustomer).orElse(null);
    }

    public CustomerEntity getByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
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
