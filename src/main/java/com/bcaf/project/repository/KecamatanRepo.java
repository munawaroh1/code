package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.Kecamatan;

public interface KecamatanRepo extends JpaRepository<Kecamatan, Long> {
	List<Kecamatan> findByKotaId(Long kotaId);
}
