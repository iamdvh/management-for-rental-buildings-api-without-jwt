package com.iamdvh.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "value")
	private Integer value;
	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity building;
}
