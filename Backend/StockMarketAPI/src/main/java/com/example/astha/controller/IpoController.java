package com.example.astha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.astha.entities.IpoDetails;
import com.example.astha.repositories.CompanyRepository;
import com.example.astha.services.IpoDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class IpoController {
	
	
	@Autowired
	private IpoDetailsService ips;
	
	@GetMapping("/getAllIpo")
	public List<IpoDetails> getAllIpo()
	{
		return ips.getAllIpo();
	}
	
	@GetMapping("/getIpoById/{id}")
	public IpoDetails getIpoById(@PathVariable ("id") Long id)
	{
		return ips.getIpoById(id);
	}
	
	@GetMapping( "/getCompanyNameByIpoId/{id}")
	public String getCompanyNameByIpoId(@PathVariable ("id") Long id)
	{
		return ips.getCompanyNameByIpoId(id);
		
	}
	
	@PostMapping( "/addIPO/{companyId}")
	public ResponseEntity<Void> addIPO(@RequestBody IpoDetails ipoDetails, @PathVariable ("companyId") Long companyId)
	{
		ips.addIPO(ipoDetails,companyId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@PostMapping("/updateAnIPO")
	public ResponseEntity<Void> updateAnIPO(@RequestBody IpoDetails ipoDetails)
	{
		ips.updateIpo(ipoDetails);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
}
