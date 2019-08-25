package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.Kelurahan;

public interface KelurahanRepo extends JpaRepository<Kelurahan, Long> {
	public List<Kelurahan> findByKecamatanId(Long kecamatanId);
}
