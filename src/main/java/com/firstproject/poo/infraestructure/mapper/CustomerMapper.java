package com.firstproject.poo.infraestructure.mapper;

import com.firstproject.poo.domain.dto.Book;
import com.firstproject.poo.domain.dto.Customer;
import com.firstproject.poo.infraestructure.entities.Cliente;
import com.firstproject.poo.infraestructure.entities.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "idCliente", target = "customerID"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "email", target = "email")
    })
    Customer toCustomer(Cliente cliente);
    List<Customer> toCustomers(List<Cliente> cliente);
    default Optional<Customer> toCustomersOptional(Optional<Cliente> cliente ){
        return  cliente.map(this::toCustomer);
    }

    @InheritInverseConfiguration
    Cliente toCliente(Customer customer);

}
