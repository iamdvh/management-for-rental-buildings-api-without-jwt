package com.iamdvh.repository.entity;

public class BuildingEntity {
	private String name;
	private String street;
	private String ward;
	private Long districId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Long getDistricId() {
		return districId;
	}
	public void setDistricId(Long districId) {
		this.districId = districId;
	}
}
