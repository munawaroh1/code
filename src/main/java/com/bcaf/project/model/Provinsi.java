package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tbl_provinsi")
public class Provinsi {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_provinsi_index")
	@TableGenerator(name="tbl_provinsi_index", table = "tbl_index", 
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	@Column(name="id", nullable = false)
	private Long id;
	
	
	@Column(name="provinsi_name", nullable = false, length = 100)
	private String name;
	

	public Provinsi() {
	}
	
	public Provinsi(String name) {
		this.name=name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public List<Kota> getListKota() { return listKota; }
	 * 
	 * public void setListKota(List<Kota> listKota) { this.listKota = listKota; }
	 */
	
}
