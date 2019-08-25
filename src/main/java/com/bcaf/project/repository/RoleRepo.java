package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	public Role findByName(String name);
	public Role findByCode(String code);
}
