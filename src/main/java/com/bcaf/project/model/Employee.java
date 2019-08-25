package com.bcaf.project.model;

import java.util.Date;

import javax.persistence.Column;

public class Employee {
	
	
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nama", nullable = false)
	private String name;
	
	@Column(name = "alamat", nullable = false)
	private String alamat;
	
	@Column(name = "tptLahir", nullable = false)
	private String tptLahir;
	
	@Column(name = "tglLahir", nullable = false)
	private Date tglLahir;
	
	@Column(name = "agama", nullable = false)
	private String agama;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "golDar", nullable = false)
	private String golDar;
	
	@Column(name = "position_id", nullable = false)
	private Integer positionId;
	
}
