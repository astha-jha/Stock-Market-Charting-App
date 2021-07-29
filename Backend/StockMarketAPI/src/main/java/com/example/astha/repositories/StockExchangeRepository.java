package com.example.astha.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.astha.entities.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> 
{
    public StockExchange findByStockExchangeName(String stockExchangeName);
}
