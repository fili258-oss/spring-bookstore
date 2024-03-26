package com.firstproject.poo.infraestructure;

import com.firstproject.poo.domain.dto.Writer;
import com.firstproject.poo.domain.repository.WriterRepository;
import com.firstproject.poo.infraestructure.entities.Autor;
import com.firstproject.poo.infraestructure.entities.Libro;
import com.firstproject.poo.infraestructure.mapper.BookMapper;
import com.firstproject.poo.infraestructure.mapper.WriterMapper;
import com.firstproject.poo.infraestructure.repositories.AutorCrudRepository;
import com.firstproject.poo.infraestructure.repositories.LibroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AutorRepository implements WriterRepository {
    @Autowired
    public AutorCrudRepository autorRepo;
    @Autowired
    public WriterMapper mapper;

    @Override
    public List<Writer> getAll() {
        List<Autor> autors  = (List<Autor>) autorRepo.findAll();
        return mapper.toWriters(autors);
    }

    @Override
    public Optional<Writer> getById(long idWriter) {
        return Optional.empty();
    }

    @Override
    public void deleteByID(long idWriter) {

    }

    @Override
    public Writer save(Writer writer) {
        return null;
    }
}
