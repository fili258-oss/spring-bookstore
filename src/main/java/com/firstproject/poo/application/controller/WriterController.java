package com.firstproject.poo.application.controller;

import com.firstproject.poo.domain.dto.Writer;
import com.firstproject.poo.domain.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/writers")
public class WriterController {
    @Autowired
    private WriterService writeService;
    @GetMapping()
    public List<Writer> getAll() {
        return writeService.getAll();
    }
    @GetMapping("{id}")
    public Optional<Writer> getById(@PathVariable("id") long idWriter) {
        return writeService.getById(idWriter);
    }
    @PostMapping()
    public Writer save(@RequestBody Writer writer) {
        return writeService.save(writer);
    }
    @DeleteMapping("{id}")
    public Boolean deleteByID(@PathVariable("id") long idWriter) {
        if(getById(idWriter).isPresent()){
            writeService.deleteByID(idWriter);
            return true;
        }
        return false;
    }
}
