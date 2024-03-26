package com.firstproject.poo.infraestructure.repositories;

import com.firstproject.poo.infraestructure.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Long> {

}
