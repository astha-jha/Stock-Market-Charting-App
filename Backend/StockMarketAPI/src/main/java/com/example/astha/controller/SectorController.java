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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.astha.entities.Company;
import com.example.astha.entities.Sector;
import com.example.astha.services.SectorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SectorController {
	
	
	@Autowired
	private SectorService sectorService;
	
	
	
	@GetMapping("/getSectorList")
	public List<Sector> getSectorList()
	{
		return sectorService.getSectorList();
	}
	
	
	
	@GetMapping("/getSectorById/{id}")
	public Sector getSectorById(@PathVariable ("id") Long id)
	{
		return sectorService.getSectorById(id);
	}
	
	@GetMapping("/getAllCompaniesInASector/{id}")
	public List<Company> getAllCompaniesInASector(@PathVariable ("id") Long id)
	{
		return sectorService.getAllCompaniesInASector(id);
		
	}
	
	@PostMapping("/addNewSector")
	public ResponseEntity<Void> addNewSector(@RequestBody Sector sector)
	{
		sectorService.addNewSector(sector);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@PostMapping( "/updateSector")
	public ResponseEntity<Void> updateSector(@RequestBody Sector sector)
	{
		sectorService.updateSector(sector);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	

	
}
