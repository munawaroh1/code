package com.bcaf.project.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bcaf.project.model.Kota;

public interface KotaRepo extends JpaRepository<Kota, Long> {
	@Query("SELECT a from Kota a where a.provinsiId = :provinsiId")
	List<Kota> findByProvinsiId(@Param("provinsiId")Long provinsiId);
}
