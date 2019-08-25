//package com.bcaf.project.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.bcaf.project.model.User;
//import com.bcaf.project.repository.UserRepo;
//import com.example.demo.domain.Vehicle;
//import com.example.demo.web.VehicleForm;
//
//import static org.springframework.http.ResponseEntity.created;
//import static org.springframework.http.ResponseEntity.noContent;
//import static org.springframework.http.ResponseEntity.ok;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("/user2")
//public class User2Controller {
//	
//	private UserRepo repo;
//	
//	public User2Controller(UserRepo repo) {
//		this.repo = repo;
//	}a
//	
//	@GetMapping("")
//	public ResponseEntity all() {
//		return ok(this.repo.findAll());
//	}
//	
//	 @PostMapping("")
//	    public ResponseEntity save(@RequestBody User user, HttpServletRequest request) {
//	        User saved = this.repo.save(repo.builder().name(user.getUsername()).build());
//	        return created(
//	            ServletUriComponentsBuilder
//	                .fromContextPath(request)
//	                .path("/v1/vehicles/{id}")
//	                .buildAndExpand(saved.getId())
//	                .toUri())
//	            .build();
//	    }
//	
//
//}
