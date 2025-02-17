package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.model.BookCategoryModel;
import com.sistema.biblioteca.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class BookCategoryController {

    @Autowired
    BookCategoryService bookCategoryService;

    @GetMapping
    public List<BookCategoryModel> findAllCategories(){
        return bookCategoryService.findAllCategories();
    }
    @GetMapping("/{id}")
    public Optional<BookCategoryModel> findCategoryById(@PathVariable Long id){
        return bookCategoryService.findCategoryById(id);
    }

    @PostMapping
    public BookCategoryModel saveCategory(@RequestBody BookCategoryModel category){
        return bookCategoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        bookCategoryService.deleteCategoryById(id);
    }

}
