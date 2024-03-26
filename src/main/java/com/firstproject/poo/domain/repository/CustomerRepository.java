package com.firstproject.poo.domain.repository;

import com.firstproject.poo.domain.dto.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> getAll();
    Optional<Customer> getById(long customerID);
    void deleteByID(long customerID);
    Customer save(Customer customer);

}
