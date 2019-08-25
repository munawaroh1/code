package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_user_ldap")

public class UserLDAP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_user_ldap")
	@TableGenerator(name = "tbl_user_ldap_index", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value",
				allocationSize = 1, initialValue = 0)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nip", nullable = false)
	private String nip;
	
	@Column(name = "role_id", nullable = false)
	private Long roleId;
	
	@Column(name = "fullname", nullable = false, length = 225)
	private String fullname;
	
	@Column(name = "department", nullable = false, length = 225)
	private String department;
	
	@Column(name = "position_id", nullable = false)
	private Long positionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}


}
