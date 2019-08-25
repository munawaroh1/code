package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_covernote")
public class CoverNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_covernote_index")
	@TableGenerator(name = "tbl_covernote_index", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value",
				allocationSize = 1, initialValue = 0)
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "covernote_no", nullable = false)
	private String covernoteNo;
	
	@Column(name = "dealer_name", nullable = false)
	private String dealerName;
	
	@Column(name = "merk", nullable = false)
	private String merk;
	
	@Column(name = "tipe_mobil", nullable = false)
	private String tipeMobil;
	
	@Column(name = "no_seri", nullable = false)
	private String noSeri;
	
	@Column(name = "no_mesin", nullable = false)
	private String noMesin;
	
	@Column(name = "no_rangka", nullable = false)
	private String noRangka;
	
	@Column(name = "warna", nullable = false)
	private String warna;
	
	@Column(name = "tahun", nullable = false)
	private String tahun;
	
	@Column(name = "alamat", nullable = false)
	private String alamat;
	
	@Column(name = "covernote_date", nullable = false)
	private String covernoteDate;
	
	@Column(name = "covernote_due_date", nullable = false)
	private String covernoteDueDate;
}
