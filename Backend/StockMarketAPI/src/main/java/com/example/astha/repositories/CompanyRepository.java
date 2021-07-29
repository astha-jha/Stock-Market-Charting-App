package com.example.astha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.astha.entities.Company;


public interface CompanyRepository extends JpaRepository<Company,Long> {
	
	public Company findByCompanyName(String companyName);
	
	public List<Company> findByCompanyNameStartingWith(String pattern);

}
