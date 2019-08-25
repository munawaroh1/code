package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.Kota;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KecamatanRepo;
import com.bcaf.project.repository.KotaRepo;
import com.bcaf.project.repository.ProvinsiRepo;

@RestController
@RequestMapping(value="/api/kota")
public class ApiKotaController {

	@Autowired
	private KotaRepo repo;
	
//	@Autowired
//	private ProvinsiRepo repoProvinsi;
	
	@RequestMapping(value="/")
	public List<Kota> list(){
		return this.repo.findAll();
	}
	
	@RequestMapping(value = "/{id}")
	public Kota detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);
	}
//	
//	@RequestMapping(value = "/{provinsiId}")
//	public Kota detail2(@PathVariable("provinsiId") Long provinsiId) {
//		return this.repo.findById(provinsiId).orElse(null);
//	}

	@PostMapping(value = "/")
	public ResponseEntity<Kota> save(@RequestBody Kota item){
		ResponseEntity<Kota> result = null;
		try {
			this.repo.save(item);
			result = new ResponseEntity<Kota>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			result = new ResponseEntity<Kota>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
