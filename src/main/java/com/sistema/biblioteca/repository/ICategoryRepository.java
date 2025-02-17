package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.model.BookCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<BookCategoryModel,Long> {
}
