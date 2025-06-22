package com.iamdvh.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {
	private static final long serialVersionUID = -6525302831793188081L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	List<UserEntity> users = new ArrayList<>();

//	@OneToMany(mappedBy = "roles")
//	private List<UserRoleEntity> userRoles = new ArrayList<>();
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public List<UserRoleEntity> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(List<UserRoleEntity> userRoles) {
//		this.userRoles = userRoles;
//	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}
