package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.Provinsi;

public interface ProvinsiRepo extends JpaRepository<Provinsi, Long>{
	public Provinsi findByName(String name);
}
