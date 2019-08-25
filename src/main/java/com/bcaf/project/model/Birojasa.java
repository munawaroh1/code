package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity 
@Table(name = "tbl_birojasa")
public class Birojasa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_birojasa_index")
	@TableGenerator(name = "tbl_birojasa_index", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value",
				allocationSize = 1, initialValue = 0)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "birojasa_name", nullable = false)
	private String birojasaName;

}
