package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<StockModel, Long> {
}
