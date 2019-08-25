package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_kecamatan")
public class Kecamatan {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_user_index")
	@TableGenerator(name = "tbl_user_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nama_kecamatan", nullable = false, length = 225)
	private String namaKecamatan;
	
	@Column(name = "kota_id", nullable = false)
	private Long kotaId;
	
	//kecamatan -  kota
	@ManyToOne
	@JoinColumn(name="kota_id", foreignKey = @ForeignKey(name="fk_kecamatan_kota_id"), insertable = false, updatable = false)
	private Kota kota;
	
	//kelurahan - kecamatan
//	@OneToMany(mappedBy = "kecamatan")
//	@JsonManagedReference
//	private List<Kelurahan> listKelurahan = new ArrayList<Kelurahan>();
	
	//constructor 
	public Kecamatan() {
		
	}
	
	//constructor
	public Kecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}
	
	//setter n getter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaKecamatan() {
		return namaKecamatan;
	}

	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}

	public Long getKotaId() {
		return kotaId;
	}

	public void setKotaId(Long kotaId) {
		this.kotaId = kotaId;
	}

	public Kota getKota() {
		return kota;
	}

	public void setKota(Kota kota) {
		this.kota = kota;
	}
//
//	public List<Kelurahan> getListKelurahan() {
//		return listKelurahan;
//	}
//
//	public void setListKelurahan(List<Kelurahan> listKelurahan) {
//		this.listKelurahan = listKelurahan;
//	}
//	

	
}
