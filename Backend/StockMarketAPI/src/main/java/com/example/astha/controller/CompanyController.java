package com.example.astha.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
import com.example.astha.entities.CompanyStockExchange;
import com.example.astha.entities.IpoDetails;
import com.example.astha.entities.StockExchange;
import com.example.astha.entities.StockPrice;
import com.example.astha.repositories.CompanyRepository;
import com.example.astha.repositories.CompanyStockExchangeRepository;
import com.example.astha.repositories.StockExchangeRepository;
import com.example.astha.services.CompanyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CompanyController {

	@Autowired
	private CompanyService cs;
	
	@Autowired
	private StockExchangeRepository SErpo;
	
	@Autowired
	private CompanyStockExchangeRepository companyStockExchangeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	
	
	@GetMapping( "/getAllCompanies")
	public List<Company> getAllCompanies()
	{
		return cs.getAllCompanies();
	}
	
	@GetMapping("/getCompanyById/{companyId}")
	public Company getCompanyById(@PathVariable ("companyId") Long companyId)
	{
		return cs.getCompanyById(companyId);
	}
		
	
	@PostMapping("/addNewCompany")
	public ResponseEntity<Void> addNewCompany(@RequestBody Company company)
	{
		cs.addNewCompany(company);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@PostMapping( "/updateNewCompany")
	public ResponseEntity<Void> updateStockExchange(@RequestBody Company company)
	{
		cs.updateNewCompany(company);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	@PostMapping("/getCompanyDetails/{companyName}")
	public Company getCompanyByName(@PathVariable ("companyName") String companyName)
	{
		return cs.getByCompanyName(companyName);
	}
	
	
	@GetMapping("/getCompaniesLike/{pattern}")
	public List<Company> getMatchingCompanies(@PathVariable ("pattern") String pattern)
	{
		return cs.getMatchingCompanies(pattern);
	}
	
	
	@GetMapping("/getIpoDetailsByCompanyName/{companyName}")
	public IpoDetails getIpoDetailsByCompanyName(@PathVariable ("companyName") String companyName)
	{
		return cs.getIpoDetailsByCompanyName(companyName);
	}
	
	@PostMapping( "/updateStockPriceOfCompany/{companyName}/{stockExchangeName}")
	public void updateStockPriceOfCompany(@RequestBody StockPrice stockPrice,@PathVariable ("companyName") String companyName,@PathVariable ("stockExchangeName") String stockExchangeName)
	{
		cs.updateStockPriceOfCompany(stockPrice,companyName,stockExchangeName);
	}
	
	@PostMapping( "/mapCompanyCode")
	public void mapcode(@RequestBody Map<String, String> text) {
		Company company = companyRepository.findByCompanyName(text.get("companyName"));
		StockExchange stockExchange = SErpo.findByStockExchangeName(text.get("stockExchangeName"));
		CompanyStockExchange cse = new CompanyStockExchange();
		cse.setCompany(company);
		cse.setStockExchange(stockExchange);
		cse.setCompanyCode(text.get("companyCode"));
		companyStockExchangeRepository.save(cse);
	}
	
	@GetMapping( "/getAllStockExchangesACompanyListedIn/{companyId}")
	public List<String> getAllStockExchangesACompanyListedIn(@PathVariable ("companyId") Long companyId)
	{
		return cs.getAllStockExchangesACompanyListedIn(companyId);
	}
	
	
	
	
	  
	
	

}
