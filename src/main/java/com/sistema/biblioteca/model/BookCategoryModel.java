package com.sistema.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="category")
public class BookCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name",nullable = false, length = 100)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookModel> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
