package com.bcaf.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_tarikan1")
public class DataTarikan {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_tarikan1_index")
	@TableGenerator(name = "tbl_tarikan1_index", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value", 
				allocationSize = 1, initialValue = 0)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "status_pinjaman", nullable = false)
	private String statusPinjaman;
	
	@Column(name = "no_rek", nullable = false)
	private String noRek;
	
	@Column(name = "no_pin", nullable = false)
	private String noPin;
	
	@Column(name = "costumer_name", nullable = false)
	private String customerName;
	
	@Column(name = "no_rangka", nullable = false)
	private String noRangka;
	
	@Column(name = "no_mesin", nullable = false)
	private String noMesin;
	
	@Column(name = "covernote_date", nullable = false)
	private String covernoteDate;
	
	@Column(name = "tipe_mobil", nullable = false)
	private String tipeMobil;
	
	@Column(name = "bpkp_name", nullable = false)
	private String bpkbName;
	
	@Column(name = "dealer_name")
	private String dealerName;
	
	@Column(name = "dealer_address")
	private String dealerAddress;
	
	@Column(name = "dealer_city")
	private String dealerCity;
	
	@Column(name = "dealer_phone")
	private String dealerPhone;
	
	@Column(name = "dealer_contact")
	private String dealerContact;
	
	@Column(name = "cmo")
	private String cmo;
	
	@Column(name = "covernote_aging", nullable = false)
	private String covernoteAging;
	
	@Column(name = "covernote_overdue", nullable = false)
	private String covernoteOverdue;
	
	@Column(name = "tgl_realisasi", nullable = false)
	private String tglRealisasi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNoRek() {
		return noRek;
	}

	public void setNoRek(String noRek) {
		this.noRek = noRek;
	}

	public String getNoPin() {
		return noPin;
	}

	public void setNoPin(String noPin) {
		this.noPin = noPin;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getNoRangka() {
		return noRangka;
	}

	public void setNoRangka(String noRangka) {
		this.noRangka = noRangka;
	}

	public String getNoMesin() {
		return noMesin;
	}

	public void setNoMesin(String noMesin) {
		this.noMesin = noMesin;
	}

	public String getCovernoteDate() {
		return covernoteDate;
	}

	public void setCovernoteDate(String covernoteDate) {
		this.covernoteDate = covernoteDate;
	}

	public String getTipeMobil() {
		return tipeMobil;
	}

	public void setTipeMobil(String tipeMobil) {
		this.tipeMobil = tipeMobil;
	}

	public String getBpkbName() {
		return bpkbName;
	}

	public void setBpkbName(String bpkbName) {
		this.bpkbName = bpkbName;
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

	public String getDealerPhone() {
		return dealerPhone;
	}

	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}

	public String getDealerContact() {
		return dealerContact;
	}

	public void setDealerContact(String dealerContact) {
		this.dealerContact = dealerContact;
	}

	public String getCmo() {
		return cmo;
	}

	public void setCmo(String cmo) {
		this.cmo = cmo;
	}

	public String getCovernoteAging() {
		return covernoteAging;
	}

	public void setCovernoteAging(String covernoteAging) {
		this.covernoteAging = covernoteAging;
	}

	public String getCovernoteOverdue() {
		return covernoteOverdue;
	}

	public void setCovernoteOverdue(String covernoteOverdue) {
		this.covernoteOverdue = covernoteOverdue;
	}

	public String getTglRealisasi() {
		return tglRealisasi;
	}

	public void setTglRealisasi(String tglRealisasi) {
		this.tglRealisasi = tglRealisasi;
	}

	public String getStatusPinjaman() {
		return statusPinjaman;
	}

	public void setStatusPinjaman(String statusPinjaman) {
		this.statusPinjaman = statusPinjaman;
	}
	
	
}
