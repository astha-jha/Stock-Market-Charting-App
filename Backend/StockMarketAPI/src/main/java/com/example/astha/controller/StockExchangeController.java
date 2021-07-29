package com.example.astha.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.astha.entities.Company;
import com.example.astha.entities.StockExchange;
import com.example.astha.services.StockExchangeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StockExchangeController {
	
	
	@Autowired
	private StockExchangeService stockExchangeService; 

	@RequestMapping(value = "/getStockExchangeList", method = RequestMethod.GET)
	public List<StockExchange> getStockExchangeList()
	{
		return stockExchangeService.getStockExchangeList();
	}
	
	@PostMapping( "/addStockExchange")
	public ResponseEntity<Void> addStockExchange(@RequestBody StockExchange stockExchange)
	{
		stockExchangeService.addStockExchange(stockExchange);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping( "/updateStockExchange")
	public ResponseEntity<Void> updateStockExchange(@RequestBody StockExchange stockExchange)
	{
		stockExchangeService.updateStockExchange(stockExchange);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@GetMapping("/getStockExchangeById/{id}")
	public StockExchange  getStockExchangeById(@PathVariable ("id") Long id)
	{
		return stockExchangeService.getStockExchangeById(id);
	}
	
	
	@GetMapping( "/getStockExchangeByName/{stockExchangeName}")
	public StockExchange getCompanyByName(@PathVariable ("stockExchangeName") String stockExchangeName)
	{
		return stockExchangeService.getStockExchangeByName(stockExchangeName);
	}
	
	@GetMapping("/getCompanyListInAStockExchange/{id}")
	public List<Company> getCompanyListInAStockExchange(@PathVariable ("id") Long id)
	{
		return stockExchangeService.getCompanyListInAStockExchange(id);
	}
	
	
	
	
	
	

}
