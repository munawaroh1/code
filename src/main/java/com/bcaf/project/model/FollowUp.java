package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_followup")
public class FollowUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_followup_index")
	@TableGenerator(name = "tbl_followup_index", table = "tbl_index", 
				pkColumnName = "index_id", valueColumnName = "index_value", 
				allocationSize = 1, initialValue = 0)
	
	@Column(name = "id", nullable = false)
	private Long id; 
	
	@Column(name = "birojasa_name")
	private String birojasaName;
	
	@Column(name = "dealer_name")
	private String dealerName;
	
	@Column(name = "dealer_address")
	private String dealerAddress;
	
	@Column(name = "no_rek")
	private String noRek;
	
	@Column(name = "no_pin")
	private String noPin;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "bpkb_name")
	private String bpkbName;
	
	@Column(name = "no_rangka")
	private String noRangka;
	
	@Column(name = "no_mesin")
	private String noMesin;
	
	@Column(name = "covernote_date")
	private String covernoteDate;
	
	@Column(name = "status_id")
	private Long statusId;
	
	@Column(name = "tgl_followup")
	private String tglFollowup;
	
	@Column(name = "keterangan")
	private String keterangan;
	
	@Column(name = "kategori_id")
	private Long kategoriId;
	
	@Column(name = "user_id")
	private Long userId;
	
	//followupp - kategori
	@ManyToOne
	@JoinColumn(name="kategori_id", foreignKey = @ForeignKey(name="fk_followup_kategori_id"), insertable = false, updatable = false)
	public KategoriPermasalahan kategoriPermasalahan;
	
	@ManyToOne
	@JoinColumn(name="status_id", foreignKey = @ForeignKey(name="fk_followup_status_id"), insertable = false, updatable = false)
	public Status status; 
	
	public FollowUp() {
		
	}

	public FollowUp(String birojasaName, String dealerName, String dealerAddress, String noRek, String noPin,
			String customerName, String bpkbName, String noRangka, String noMesin, String covernoteDate, Long statusId,
			String tglFollowup, String keterangan, Long kategoriId, Long userId) {
		this.birojasaName = birojasaName;
		this.dealerName = dealerName;
		this.dealerAddress = dealerAddress;
		this.noRek = noRek;
		this.noPin = noPin;
		this.customerName = customerName;
		this.bpkbName = bpkbName;
		this.noRangka = noRangka;
		this.noMesin = noMesin;
		this.covernoteDate = covernoteDate;
		this.statusId = statusId;
		this.tglFollowup = tglFollowup;
		this.keterangan = keterangan;
		this.kategoriId = kategoriId;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBirojasaName() {
		return birojasaName;
	}

	public void setBirojasaName(String birojasaName) {
		this.birojasaName = birojasaName;
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

	public String getBpkbName() {
		return bpkbName;
	}

	public void setBpkbName(String bpkbName) {
		this.bpkbName = bpkbName;
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

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getTglFollowup() {
		return tglFollowup;
	}

	public void setTglFollowup(String tglFollowup) {
		this.tglFollowup = tglFollowup;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public Long getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(Long kategoriId) {
		this.kategoriId = kategoriId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public KategoriPermasalahan getKategoriPermasalahan() {
		return kategoriPermasalahan;
	}

	public void setKategoriPermasalahan(KategoriPermasalahan kategoriPermasalahan) {
		this.kategoriPermasalahan = kategoriPermasalahan;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}



}
