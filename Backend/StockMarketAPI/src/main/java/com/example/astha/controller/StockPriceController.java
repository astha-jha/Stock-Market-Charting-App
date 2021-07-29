package com.example.astha.controller;

import java.sql.Date;
import java.util.List;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.astha.entities.StockPrice;
import com.example.astha.services.StockPriceService;



@RestController
@CrossOrigin


public class StockPriceController {
	
	
	@Autowired
	private StockPriceService sps;
	
	@GetMapping("/getCompanyStockPrice/{companyName}/{startDate}/{endDate}/{stockExchangeName}")
	public List<StockPrice> findCompanyStockPriceDetails(@PathVariable ("companyName") String companyName,
			@PathVariable ("startDate") Date startDate,
			@PathVariable ("endDate") Date endDate,
			@PathVariable ("stockExchangeName") String stockExchangeName){
		
		return sps.findCompanyStockPriceDetails(companyName, startDate, endDate,stockExchangeName);
	}
	/*
	
	@GetMapping("/AllStockPrices")
		public List<StockPrice> getAllStockPrice(){
			return stockPriceService.AllStockPrice();
		}
	}
	*/

}
