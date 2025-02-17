package com.sistema.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title",nullable = false, length = 100)
    private String title;
    @Column(name = "author",nullable = false, length = 100)
    private String author;
    @Column(name = "isbn",nullable = false,length = 20)
    private String isbn;
    @Column(name = "publication_year")
    private int year;
    @Column(name = "volume")
    private int volume;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategoryModel category;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private StockModel stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookCategoryModel getCategory() {
        return category;
    }

    public void setCategory(BookCategoryModel category) {
        this.category = category;
    }

    public StockModel getStock() {
        return stock;
    }

    public void setStock(StockModel stock) {
        this.stock = stock;
    }

}
