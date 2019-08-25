package com.bcaf.project.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.Provinsi;
import com.bcaf.project.model.Response;
import com.bcaf.project.model.User;

import com.bcaf.project.repository.UserRepo;

@RestController
@RequestMapping(value="/api/users")
public class ApiUserController {
	
	@Autowired
	private UserRepo repo;
	
	@GetMapping
	public List<User> list(){
		return this.repo.findAll();
		//findAll().. method g ada di jparepository
	}
	
	@RequestMapping(value="/{id}")
	public User detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);
	}
	
	private String service = "User";

//	@PostMapping(value = "/")
//	public ResponseEntity<Response> save(@RequestBody @Validated User item) {
//		String curMethodName = new Throwable().getStackTrace()[0].getMethodName();
//
//		Response response = new Response();
//		response.setService(this.getClass().getName() + " - " + curMethodName);
//		response.setMessage("Berhasil Simpan");
//		response.setData(item);
//
//		this.repo.save(item);
//
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
//	}
	

	@PostMapping(value = "/create/")
	public ResponseEntity<Response> save(@RequestBody @Validated User item) {
		String curMethodName = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		
		
		
		response.setService(this.getClass().getName() + " - " + curMethodName);
		response.setMessage("Berhasil Simpan");
		response.setData(item);

		this.repo.save(item);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<Response> findByUsernameAndPassword(@RequestParam (value="username") String username, @RequestParam(value="password") String password) {
		String curMethodName = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		
		response.setService(this.getClass().getName() + " - " + curMethodName);
		response.setMessage("Berhasil Simpan");
		response.setData(this.repo.findByUsernameAndPassword(username, password));

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	
}
