package com.example.astha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.astha.entities.Sector;

public interface SectorRepository extends JpaRepository<Sector,Long>
{

	public Sector findBySectorName(String sectorName);

}
