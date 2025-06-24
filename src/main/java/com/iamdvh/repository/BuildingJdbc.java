  package com.iamdvh.repository;

import java.util.List;

import com.iamdvh.repository.entity.BuildingEntity;

public interface BuildingJdbc {
	List<BuildingEntity> findAll();
}
