package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.PembagianBirojasa;

@Repository
public interface PembagianBirojasaRepo extends JpaRepository<PembagianBirojasa, Long>{
		@Query("SELECT bj FROM PembagianBirojasa bj")
	 public List<PembagianBirojasa> cariBiroJasa();
//	List<PembagianBirojasa> findById();
	
	
}
