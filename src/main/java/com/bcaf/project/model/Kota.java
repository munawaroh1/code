package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tbl_kota")
public class Kota {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kota_index")
	@TableGenerator(name="tbl_kota_index", table = "tbl_index", 
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	@Column(name="id")
	private Long id;
	
	@Column(name="kota_name", nullable = false, length = 100)
	private String name;
	
	@Column(name="provinsi_id",nullable = false)
	private Long provinsiId;
	
	//kota - provinsi
	@ManyToOne
	@JoinColumn(name="provinsi_id", foreignKey = @ForeignKey(name="fk_kota_provinsi_id"), insertable = false, updatable = false)
	//reduce infinity loop di taruh sini dan di --proovinsi--
//	@JsonManagedReference
	private Provinsi provinsi;
	
//	//kkecamatan - kota
//	@OneToMany(mappedBy = "kota")
//	@JsonBackReference
//	private List<Kecamatan> listKecamatan = new ArrayList<Kecamatan>();
	

	//constructor
	public Kota() {
	}
	
	public Kota(String name, Long provinsiId) {
		this.name=name;
		this.provinsiId=provinsiId;
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

	public Long getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(Long provinsiId) {
		this.provinsiId = provinsiId;
	}

	public Provinsi getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}

//	public List<Kecamatan> getListKecamatan() {
//		return listKecamatan;
//	}
//
//	public void setListKecamatan(List<Kecamatan> listKecamatan) {
//		this.listKecamatan = listKecamatan;
//	}
	
}
