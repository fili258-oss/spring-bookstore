package com.firstproject.poo.infraestructure;

import com.firstproject.poo.domain.dto.Customer;
import com.firstproject.poo.domain.repository.CustomerRepository;
import com.firstproject.poo.infraestructure.entities.Cliente;
import com.firstproject.poo.infraestructure.entities.Libro;
import com.firstproject.poo.infraestructure.mapper.CustomerMapper;
import com.firstproject.poo.infraestructure.repositories.ClienteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {
    @Autowired
    public ClienteCrudRepository clienteRepo;
    @Autowired
    public CustomerMapper mapper;

    @Override
    public List<Customer> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteRepo.findAll();
        return mapper.toCustomers(clientes);
    }

    @Override
    public Optional<Customer> getById(long customerID) {
        Optional<Cliente> cliente = clienteRepo.findById(customerID);
        return mapper.toCustomersOptional(cliente);
    }

    @Override
    public void deleteByID(long customerID) {

    }

    @Override
    public Customer save(Customer customer) {
        Cliente cliente = mapper.toCliente(customer);
        return mapper.toCustomer(clienteRepo.save(cliente));
    }
}
