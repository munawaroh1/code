package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	public User findByEmail(String email);
	
	public User findByUsernameAndPassword(String username, String password);
	
	User findOneByUsername(String username);
}
