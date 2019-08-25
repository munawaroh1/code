package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long>{

}
