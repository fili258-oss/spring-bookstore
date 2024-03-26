package com.firstproject.poo.domain.service;

import com.firstproject.poo.domain.dto.Customer;
import com.firstproject.poo.domain.repository.CustomerRepository;
import com.firstproject.poo.infraestructure.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;


    public List<Customer> getAll() {

        return customerRepo.getAll();
    }


    public Optional<Customer> getById(long customerID) {

        return customerRepo.getById(customerID);
    }


    public boolean deleteByID(long customerID) {
        if(getById(customerID).isPresent()){
            customerRepo.deleteByID(customerID);
            return true;
        }
        return false;
    }


    public Customer save(Customer customer) {

        return customerRepo.save(customer);
    }
}
