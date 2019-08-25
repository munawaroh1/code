package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_user")
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_user_index")
	@TableGenerator(name = "tbl_user_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)

	@Column(name = "id")
	private Long id;

	@Column(name = "username", nullable = false, length = 64)
	private String username;

	@Column(name = "password", nullable = false, length = 225)
	private String password;

	@Column(name = "email", nullable = false, length = 225)
	private String email;

	@Column(name = "is_active", nullable = false, length = 1)
	private Integer isActive;

	@Column(name = "is_enable", nullable = false, length = 1)
	private Integer isEnable;

	@Column(name = "is_locked", nullable = false, length = 1)
	private Integer isLocked;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usrole_user_id")), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usrole_role_id")), foreignKey = @ForeignKey(name = "fk_usrole_user_id"), inverseForeignKey = @ForeignKey(name = "fk_usrole_role_id"))

	private List<Role> listRole = new ArrayList<Role>();

	// cnstructor
	public User() {

	}

	// constructor
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.isActive = 1;
		this.isEnable = 1;
		this.isLocked = 0;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role:listRole) {
			String name=role.getName().toUpperCase();
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
