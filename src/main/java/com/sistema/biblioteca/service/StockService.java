package com.sistema.biblioteca.service;

import com.sistema.biblioteca.model.StockModel;
import com.sistema.biblioteca.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    IStockRepository stockRepository;

    public List<StockModel> findAllStock(){
        return stockRepository.findAll();
    }

    public Optional<StockModel> findStockById(Long id){
        return stockRepository.findById(id);
    }

    public StockModel saveStock(StockModel stock){
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id){
        stockRepository.deleteById(id);
    }
}
