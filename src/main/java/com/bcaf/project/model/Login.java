package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

public class Login {

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_login_index")
	@TableGenerator(name = "tbl_login_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)

	@Column(name = "id")
	private Long id;

	@Column(name = "username", nullable = false, length = 64)
	private String username;

	@Column(name = "password", nullable = false, length = 225)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
