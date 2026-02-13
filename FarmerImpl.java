package com.demo.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.FarmerDao;
import com.demo.model.Farmer;

@Service
@Transactional
public class FarmerImpl implements FarmerService {
	@Autowired
	private FarmerDao fd;

	@Override
	public Farmer createFarmer(Farmer farmer) {
		return fd.save(farmer);
	}

	@Override
	public List<Farmer> getAll() {
		return fd.findAll();
	}

//	@Override
//	public Optional<Farmer> getById(Long id) {
//		return fd.findById(id);
//	}

	@Override
	public Farmer updateFarmer(Long id, Farmer farmer) {

		Optional<Farmer> existingFarmer = fd.findById(id);
		if (existingFarmer.isPresent()) {
			Farmer f = existingFarmer.get();
			f.setName(farmer.getName());
			f.setAge(farmer.getAge());
			f.setMobile(farmer.getMobile());
			f.setVillage(farmer.getVillage());
			f.setLandArea(farmer.getLandArea());
			return fd.save(f);
		} else {
			throw new RuntimeException("Farmer Not Found with ID:" + id);
		}
	}

	@Override
	public String deleteFarmerById(Long id) {
		if (!fd.existsById(id)) {
			return "NOT_FOUND";
		}

		fd.deleteById(id);
		return "deleted";

	}

	@Override
	public List<Farmer> findByNameContainingIgnoreCase(String name) {
		return fd.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Farmer> findByAgeBetween(int minAge, int maxAge) {
		return fd.findByAgeBetween(minAge, maxAge);
	}

	@Override
	public List<Farmer> findByLandAreaGreaterThan(double landArea) {
		return fd.findByLandAreaGreaterThan(landArea);
	}

	@Override
	public List<Farmer> findAllByOrderByNameAsc() {
		return fd.findAllByOrderByNameAsc();
	}

	@Override
	public long countFarmers() {
		return fd.count();
	}

	@Override
	public double getTotalLandArea() {
		return fd.getTotalLandArea();
	}

	@Override
	public int getMaxAge() {
		return fd.getMaxAge();
	}

	@Override
	public int getMinAge() {
		return fd.getMinAge();
	}

	@Override
	public Farmer findFarmerById(long id) {
		return fd.findFarmerById(id);
	}

}
