package com.sistema.biblioteca.service;

import com.sistema.biblioteca.model.BookModel;
import com.sistema.biblioteca.repository.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private IBooksRepository booksRepository;

    public List<BookModel> findAllBooks(){
       return booksRepository.findAll();
    }

    public Optional<BookModel> findBookById(Long id){
        return booksRepository.findById(id);
    }

    public BookModel saveBook(BookModel book){
        return booksRepository.save(book);
    }

    public void deleteBook(Long id){
       booksRepository.deleteById(id);
    }
}
