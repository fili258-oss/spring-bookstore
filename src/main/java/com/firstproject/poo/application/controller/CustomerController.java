package com.firstproject.poo.application.controller;

import com.firstproject.poo.domain.dto.Customer;
import com.firstproject.poo.domain.dto.Writer;
import com.firstproject.poo.domain.service.CustomerService;
import com.firstproject.poo.domain.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping()
    public List<Customer> getAll() {
        return customerService.getAll();
    }
    @GetMapping("{id}")
    public Optional<Customer> getById(@PathVariable("id") long autorID) {
        return customerService.getById(autorID);
    }
    @PostMapping()
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
    @DeleteMapping("{id}")
    public Boolean deleteByID(@PathVariable("id") long autorID) {
        if(getById(autorID).isPresent()){
            customerService.deleteByID(autorID);
            return true;
        }
        return false;
    }
}
