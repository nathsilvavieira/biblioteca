package com.sistema.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name="stock")
public class StockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "qtdTotal")
    private int quantityTotal;

    @Column(name = "qtdAvailable")
    private int quantityAvailable;

    @OneToOne
    @JoinColumn(name="book_id",nullable = false)
    private BookModel book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(int quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }
}
