package com.example.astha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.astha.entities.StockPrice;
import com.example.astha.services.StockPriceService;


@RestController
@CrossOrigin
public class UploadExcelController {
	
	@Autowired
	private StockPriceService sps;
	
	@PostMapping("/uploadStockPriceExcel")
	public ResponseEntity<Void> uploadStockPriceExcel(@RequestBody  List<List<Object>> stockPriceList)
	{
		sps.uploadStockPriceExcel(stockPriceList);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
