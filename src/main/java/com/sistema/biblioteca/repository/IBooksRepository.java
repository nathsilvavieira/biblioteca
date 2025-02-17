package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBooksRepository extends JpaRepository<BookModel, Long>{
}
