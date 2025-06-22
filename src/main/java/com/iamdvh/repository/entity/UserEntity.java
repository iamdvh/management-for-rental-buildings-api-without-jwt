package com.iamdvh.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	private static final long serialVersionUID = -4988455421375043688L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username", unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "status", nullable = false)
	private String status;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "email")
	private Long email;
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
//	private List<RoleEntity> roles;
//	@OneToMany(mappedBy = "users")
//	private List<UserRoleEntity> userRoles = new ArrayList<>();
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getEmail() {
		return email;
	}

	public void setEmail(Long email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<UserRoleEntity> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(List<UserRoleEntity> userRoles) {
//		this.userRoles = userRoles;
//	}

//	public List<RoleEntity> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<RoleEntity> roles) {
//		this.roles = roles;
//	}
}
