package com.example.astha.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.astha.entities.Company;
import com.example.astha.entities.CompanyStockExchange;
import com.example.astha.entities.StockExchange;
import com.example.astha.repositories.CompanyStockExchangeRepository;
import com.example.astha.repositories.StockExchangeRepository;

@Service
public class StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	@Autowired
	private CompanyStockExchangeRepository companyStockExchangeRepository;

	public List<StockExchange> getStockExchangeList() {
		return stockExchangeRepository.findAll();
	}

	public void addStockExchange(StockExchange stockExchange) {
		stockExchangeRepository.save(stockExchange);
	}

	public StockExchange getStockExchangeById(Long id) {
		return stockExchangeRepository.findById(id).get();
	}

	public StockExchange getStockExchangeByName(String stockExchangeName) {
		return stockExchangeRepository.findByStockExchangeName(stockExchangeName);
	}

	public List<Company> getCompanyListInAStockExchange(Long id) {
		StockExchange stockExchange = stockExchangeRepository.findById(id).get();
		List<CompanyStockExchange> companyStockExchangeMap = stockExchange.getCompstockmap();
		List<Company> companyList = companyStockExchangeMap.stream().map(x -> x.getCompany()).collect(Collectors.toList());
		return companyList;
	}

	public void updateStockExchange(StockExchange stockExchange) {
		StockExchange stckEx = stockExchangeRepository.findById(stockExchange.getId()).get();
		stckEx.setstockExchangeName(stockExchange.getstockExchangeName());
		stckEx.setBrief(stockExchange.getBrief());
		stckEx.setContactAddress(stockExchange.getContactAddress());
		stckEx.setstockExchangeName(stockExchange.getstockExchangeName());
		stckEx.setRemarks(stockExchange.getRemarks());
		stockExchangeRepository.save(stckEx);
		
	}
	


}
