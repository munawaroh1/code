package com.bcaf.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.Provinsi;
import com.bcaf.project.model.Response;
import com.bcaf.project.model.User;
import com.bcaf.project.repository.UserRepo;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;
//	@Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("user/index");
		List<User> list = this.userRepo.findAll();

		view.addObject("list", list);
		return view;
	}
	
	@PostMapping("coba")
	public ModelAndView findUser(@Valid @RequestBody User user) {
		ModelAndView view = new ModelAndView("user/index");
		List<User> list = this.userRepo.findAll();

		view.addObject("list", list);
		return view;
	}
	
	private String service = "User";

	@PostMapping(value = "/")
	public ResponseEntity<Response> save(@RequestBody @Validated User item) {
		String curMethodName = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		response.setService(this.getClass().getName() + " - " + curMethodName);
		response.setMessage("Berhasil Simpan");
		response.setData(item);

		this.userRepo.save(item);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<Response> findAll() {
		String curMethodName = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		response.setService(this.getClass().getName() + " - " + curMethodName);
		response.setMessage("Berhasil Simpan");
		response.setData(this.userRepo.findAll());

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
//	// from chrome
//	public UserController(UserRepo userRepo,
//            BCryptPasswordEncoder bCryptPasswordEncoder) {
//	this.userRepo = userRepo;
//	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
//	
//	@PostMapping("/sign-up")
//	public void signUp(@RequestBody User user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//	}

	
}
