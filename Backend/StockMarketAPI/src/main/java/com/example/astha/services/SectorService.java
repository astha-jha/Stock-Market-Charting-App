package com.example.astha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.astha.entities.Company;
import com.example.astha.entities.Sector;
import com.example.astha.repositories.CompanyRepository;
import com.example.astha.repositories.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	private SectorRepository sectorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	public List<Sector> getSectorList() {
		return sectorRepository.findAll();
	}

	
	public List<Company> getAllCompaniesInASector(Long id) {
		
		Sector sector = sectorRepository.getById(id);
		return sector.getCompanies();
	}


	public void addNewSector(Sector sector) {
		sectorRepository.save(sector);
	}


	public Sector getSectorById(Long id) {
		return sectorRepository.findById(id).get();
	}


	public void updateSector(Sector sector) {
		Sector sec = sectorRepository.findById(sector.getId()).get();
		sec.setSectorName(sector.getSectorName());
		sec.setBrief(sector.getBrief());
		sectorRepository.save(sec);
		List<Company> companyList = sec.getCompanies();
		for(Company x: companyList)
		{
			x.setSector(sec);
			x.setSectorName(sec.getSectorName());
			companyRepository.save(x);
		}
	}


	




}
