package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_status")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_status_index")
	@TableGenerator(name = "tbl_status_index", table = "tbl_index", 
				pkColumnName = "index_id", valueColumnName = "index_value", 
				allocationSize = 1, initialValue = 0)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "status_name", length = 50)
	private String statusName;

	public Status() {
		
	}
	
	public Status(Long id, String statusName) {
		this.id = id;
		this.statusName = statusName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	
	
}
