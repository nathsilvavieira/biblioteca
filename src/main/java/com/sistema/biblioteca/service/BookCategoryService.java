package com.sistema.biblioteca.service;

import com.sistema.biblioteca.model.BookCategoryModel;
import com.sistema.biblioteca.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    public List<BookCategoryModel> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<BookCategoryModel> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public BookCategoryModel saveCategory(BookCategoryModel category){
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }
}
