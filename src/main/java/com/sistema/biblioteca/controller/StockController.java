package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.model.StockModel;
import com.sistema.biblioteca.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping
    public List<StockModel> findAll(){
        return stockService.findAllStock();
    }

    @GetMapping("/{id}")
    public Optional<StockModel> findStockById(@PathVariable Long id){
        return stockService.findStockById(id);
    }

    @PostMapping
    public StockModel saveStockModel(@RequestBody StockModel stock){
        return stockService.saveStock(stock);
    }

    @DeleteMapping
    public void deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    }
}
