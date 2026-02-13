package com.demo.dao.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.Farmer;

public interface FarmerService {
	
	Farmer findFarmerById(long id);

	Farmer createFarmer(Farmer farmer);

	List<Farmer> getAll();

//	Optional<Farmer> getById(Long id);

	Farmer updateFarmer(Long id, Farmer farmer);

	String deleteFarmerById(Long id);

	List<Farmer> findByNameContainingIgnoreCase(String name);

	List<Farmer> findByAgeBetween(int minAge, int maxAge);

	List<Farmer> findByLandAreaGreaterThan(double landArea);

	List<Farmer> findAllByOrderByNameAsc();

	long countFarmers();

	double getTotalLandArea();

	int getMaxAge();

	int getMinAge();
}
