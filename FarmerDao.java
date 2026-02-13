package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Farmer;

@Repository
public interface FarmerDao  extends JpaRepository<Farmer, Long>{
	
	
	Farmer findFarmerById(long id);
	List<Farmer> findByNameContainingIgnoreCase(String name);

	List<Farmer> findByAgeBetween(int minAge, int maxAge);
	List<Farmer> findByLandAreaGreaterThan(double landArea);
	List<Farmer> findAllByOrderByNameAsc();
	
	@Query("SELECT SUM(f.landArea) FROM Farmer f")
	Double getTotalLandArea();

	@Query("SELECT MAX(f.age) FROM Farmer f")
	Integer getMaxAge();

	@Query("SELECT MIN(f.age) FROM Farmer f")
	Integer getMinAge();

	

}
