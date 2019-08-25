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

import com.bcaf.project.model.Kecamatan;
import com.bcaf.project.model.Kota;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KecamatanRepo;
import com.bcaf.project.repository.KotaRepo;
import com.bcaf.project.repository.ProvinsiRepo;

@RestController
@RequestMapping(value="/api/kecamatan")
public class ApiKecamatanController {

	@Autowired
	private KecamatanRepo repo;
	
	@RequestMapping(value="/")
	public List<Kecamatan> list(){
		return this.repo.findAll();
	}
	
	@RequestMapping(value = "/{id}")
	public Kecamatan detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);

	}
	
	@PostMapping(value = "/")
	public ResponseEntity<Kecamatan> save(@RequestBody Kecamatan item){
		ResponseEntity<Kecamatan> result = null;
		try {
			this.repo.save(item);
			result = new ResponseEntity<Kecamatan>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			result = new ResponseEntity<Kecamatan>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
