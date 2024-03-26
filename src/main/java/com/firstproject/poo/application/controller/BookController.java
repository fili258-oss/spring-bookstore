package com.firstproject.poo.application.controller;

import com.firstproject.poo.domain.dto.Book;
import com.firstproject.poo.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookSrv;

    @GetMapping()
    public List<Book> getAll(){
        return bookSrv.getAll();
    }
    @GetMapping("{id}")
    public Optional<Book> getByID(@PathVariable("id") long bookID){
        return bookSrv.getByID(bookID);
    }

    @PostMapping()
    public Book save (@RequestBody Book book){
        return bookSrv.save(book);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") int bookID){
        if(getByID(bookID).isPresent()){
            bookSrv.delete(bookID);
            return true;
        }
        return false;
    }
}
