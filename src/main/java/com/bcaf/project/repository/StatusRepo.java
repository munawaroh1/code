package com.bcaf.project.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long>{

//	public List<Status> findByStatusName(String statusName, Sort sort);
//	
}
