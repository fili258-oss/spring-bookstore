package com.firstproject.poo.domain.service;


import com.firstproject.poo.domain.dto.Writer;
import com.firstproject.poo.domain.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterService {
    @Autowired
    private WriterRepository writerRepo;

    public List<Writer> getAll() {
        return writerRepo.getAll();
    }
    public Optional<Writer> getById(long idWriter) {
        return writerRepo.getById(idWriter);
    }

    public Writer save(Writer writer) {
        return writerRepo.save(writer);
    }

    public Boolean deleteByID(long idWriter) {
        if(getById(idWriter).isPresent()){
            writerRepo.deleteByID(idWriter);
            return true;
        }
        return false;
    }

}
