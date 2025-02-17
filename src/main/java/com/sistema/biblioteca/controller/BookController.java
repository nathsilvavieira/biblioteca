package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.model.BookModel;
import com.sistema.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookModel> findAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<BookModel> findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping
    public BookModel saveBook(@RequestBody BookModel book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
