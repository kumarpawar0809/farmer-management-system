package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.service.FarmerService;
import com.demo.model.Farmer;

@RestController
@RequestMapping(value = "/farmers")
public class FarmerController {
	@Autowired
	private FarmerService fs;

	@PostMapping
	public Farmer addFarmer(@RequestBody Farmer farmer) {
		Farmer f = fs.createFarmr(farmer);

		return f;

	}

	@GetMapping
	public List<Farmer> getAllFarmers() {
		return fs.getAll();
	}

	@GetMapping(value = "/{id}")
	public Farmer getFarmerById(@PathVariable Long id) {
		return fs.findFarmerById(id);

	}

	@PutMapping(value = "/{id}")
	public Farmer updateFarmer(@PathVariable Long id, @RequestBody Farmer farmer) {
		Farmer updatedFarmer = fs.updateFarmer(id, farmer);

		return updatedFarmer;
	}

	@DeleteMapping(value = "/{id}")
	public String deleteFarmerById(@PathVariable Long id) {

		String status = fs.deleteFarmerById(id);

		if ("deleted".equals(status)) {
			return "Farmer Deleted Successfully..!!";
		} else {
			return "Farmer Not Found with ID: " + id;
		}
	}

	@GetMapping(value = "/search/by-name/{name}")
	public List<Farmer> findFarmerByName(@PathVariable String name) {

		return fs.findByNameContainingIgnoreCase(name);
	}

	@GetMapping(value = "/search/by-age/{minAge}/{maxAge}")
	public List<Farmer> findAgeBetween(@PathVariable int minAge, @PathVariable int maxAge) {
		return fs.findByAgeBetween(minAge, maxAge);
	}

	@GetMapping(value = "/search/by-land-area/{landArea}")
	public List<Farmer> getLandAReaGreaterThan(@PathVariable double landArea) {
		return fs.findByLandAreaGreaterThan(landArea);
	}

	@GetMapping(value = "/sort/by-name")
	public List<Farmer> getAllByOrderByNameAsc() {
		return fs.findAllByOrderByNameAsc();
	}

	@GetMapping(value = "/count")
	public Long countFarmers() {
		return fs.countFarmers();
	}

	@GetMapping(value = "/total-area")
	public double getTotalArea() {
		return fs.getTotalLandArea();
	}

	@GetMapping(value = "/max-age")
	public int getMaxAge() {
		return fs.getMaxAge();
	}

	@GetMapping(value = "/min-age")
	public int getMinAge() {
		return fs.getMinAge();
	}
}
