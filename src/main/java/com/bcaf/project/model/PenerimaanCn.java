package com.bcaf.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.dom4j.io.STAXEventReader;

@Entity
@Table(name = "tbl_penerimaan_cn")
public class PenerimaanCn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_penerimaan_cn_index")
	@TableGenerator(name = "tbl_penerimaan_cn", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value",
				allocationSize = 1, initialValue = 0)
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "tgl_realisasi", nullable = false)
	private String tglRealisasi;
	
	@Column(name = "area_custodian", nullable = false)
	private String areaCustodian;
	
	@Column(name = "area_operation", nullable = false)
	private String areaOperation;
	
	@Column(name = "no_kontrak", nullable = false)
	private String noKontrak;
	
	@Column(name = "cabang", nullable = false)
	private String cabang;
	
	@Column(name = "no_rek", nullable = false)
	private String noRek;
	
	@Column(name = "no_pin", nullable = false)
	private String noPin;
	
	@Column(name = "nama_konsumen", nullable = false)
	private String namaKonsumen;
	
	@Column(name = "dealer_name", nullable = false)
	private String dealerName;
	
	@Column(name = "covernote_name", nullable = false)
	private String covernoteNo;
	
	@Column(name = "covernote_date", nullable = false)
	private String covernoteDate;
	
	@Column(name = "covernote_due_date", nullable = false)
	private String covernoteDueDate;
	
}
