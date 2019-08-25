package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.FollowUp;

@Repository
public interface FollowupRepo extends JpaRepository<FollowUp, Long>{
//	public FollowUp findById(String id);
////	
//	@Query("SELECT a from FollowUp a where a.kategoriId = :kategoriId")
//	public List<FollowUp> findbyKategoriId(@Param("kategoriId")Long kategoriId);
//	
//	@Query("SELECT a from FollowUp a where a.statusId = :statusId")
//	List<FollowUp> findbyStatusId(@Param("statusId")Long statusId);
//	
	
	public List<FollowUp> findByKategoriId(Long kategoriId);
	public List<FollowUp> findByStatusId(Long statusId);
	
}
