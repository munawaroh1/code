package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.Kota;
import com.bcaf.project.repository.KotaRepo;

@RestController
@RequestMapping("/api/v1")
public class ApiKota2Controller {
	
	@Autowired
	private KotaRepo kotaRepo;
	
	@GetMapping("/addresses")
	public List<Kota> getAllKota() {
		return kotaRepo.findAll();
	}
	
	@RequestMapping(value = "/addresses/{id}")
	public Kota detail(@PathVariable("id") Long id) {
		return this.kotaRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/addresses/{provinsiId}")
	public List<Kota> getUserKota(@RequestParam("provinsiId") Long provinsiId){
		return kotaRepo.findByProvinsiId(provinsiId);
	}
}
