package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_pembagian_birojasa")
public class PembagianBirojasa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_pembagian_birojasa_index")
	@TableGenerator(name = "tbl_pembagian_birojasa_index", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value",
				allocationSize = 1, initialValue = 0)
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "dealer_name", nullable = false)
	private String dealerName;
	
	@Column(name = "dealer_address", nullable = false)
	private String dealerAddress;
	
	@Column(name = "dealer_city", nullable = false)
	private String dealerCity;
	
	@Column(name = "birojasa_name", nullable = false)
	private String birojasaName;
	
	@Column(name = "cabang_kelola", nullable = false)
	private String cabangKelola;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public String getDealerCity() {
		return dealerCity;
	}

	public void setDealerCity(String dealerCity) {
		this.dealerCity = dealerCity;
	}

	public String getBirojasaName() {
		return birojasaName;
	}

	public void setBirojasaName(String birojasaName) {
		this.birojasaName = birojasaName;
	}

	public String getCabangKelola() {
		return cabangKelola;
	}

	public void setCabangKelola(String cabangKelola) {
		this.cabangKelola = cabangKelola;
	}
	
	
	
//	public PembagianBirojasa() {
//	}

//	public PembagianBirojasa(String dealerName, String dealerAddress, String dealerCity, String birojasaName, String cabangKelola) {
//		this.dealerName = dealerName;
//		this.dealerAddress = dealerAddress;
//		this.dealerCity = dealerCity;
//		this.birojasaName = birojasaName;
//		this.cabangKelola = cabangKelola;
//	
//	}
}