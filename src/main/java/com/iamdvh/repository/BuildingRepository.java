package com.iamdvh.repository;

import java.util.List;

import com.iamdvh.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll();
	BuildingEntity findById(Long buildingId);
}
