package com.example.astha.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.astha.entities.Company;
import com.example.astha.entities.CompanyStockExchange;
import com.example.astha.entities.StockExchange;

public interface CompanyStockExchangeRepository extends JpaRepository<CompanyStockExchange,Long> {

	public CompanyStockExchange findByCompanyAndStockExchange(Company company, StockExchange StockExchange);

	public CompanyStockExchange findByCompanyCode(String companyCode);

}
