package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.DataTarikan;
@Repository
public interface DataTarikanRepo extends JpaRepository<DataTarikan, Long>{	
	public List<DataTarikan> findAll();
}
