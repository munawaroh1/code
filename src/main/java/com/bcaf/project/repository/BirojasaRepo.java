package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Birojasa;


@Repository
public interface BirojasaRepo extends JpaRepository<Birojasa, Long>{	

}
