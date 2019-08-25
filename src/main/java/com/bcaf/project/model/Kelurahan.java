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
@Table(name = "tbl_kelurahan")
public class Kelurahan {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_user_index")
	@TableGenerator(name = "tbl_user_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nama_kelurahan", nullable = false, length = 225)
	private String namaKelurahan;
	
	@Column(name = "kecamatan_id", nullable = false)
	private Long kecamatanId;
	
	@Column(name = "kode_pos", nullable = false, length = 225)
	private String kodePos;
	
	//kelurahan-kecamatan
	@ManyToOne
	@JoinColumn(name="kecamatan_id", foreignKey = @ForeignKey(name="fk_keluarahan_kecamatan_id"), insertable = false, updatable = false)
	private Kecamatan kecamatan;
	
	//constructor 
	public Kelurahan() {
		
	}
	
	//constructor
	public Kelurahan(String namaKelurahan, String kodePos) {
		this.namaKelurahan = namaKelurahan;
		this.kodePos = kodePos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaKelurahan() {
		return namaKelurahan;
	}

	public void setNamaKelurahan(String namaKelurahan) {
		this.namaKelurahan = namaKelurahan;
	}

	public Long getKecamatanId() {
		return kecamatanId;
	}

	public void setKecamatanId(Long kecamatanId) {
		this.kecamatanId = kecamatanId;
	}

	public String getKodePos() {
		return kodePos;
	}

	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}

	public Kecamatan getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(Kecamatan kecamatan) {
		this.kecamatan = kecamatan;
	}
	
	
}
