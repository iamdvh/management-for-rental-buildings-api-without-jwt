package com.iamdvh.repository;

import java.util.List;
import java.util.Map;

import com.iamdvh.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(Map<String, Object> params, List<String> types);
	BuildingEntity findById(Long buildingId);
	
}
