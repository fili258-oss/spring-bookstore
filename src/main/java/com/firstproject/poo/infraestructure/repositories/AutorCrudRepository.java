package com.firstproject.poo.infraestructure.repositories;

import com.firstproject.poo.infraestructure.entities.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorCrudRepository extends CrudRepository<Autor, Long> {

}
