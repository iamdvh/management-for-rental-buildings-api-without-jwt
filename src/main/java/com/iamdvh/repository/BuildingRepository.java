package com.iamdvh.repository;

import java.util.List;

import com.iamdvh.dto.request.BuildingSearchRequest;
import com.iamdvh.repository.entity.BuildingEntity;

public interface BuildingRepository {
	public List<BuildingEntity> findAll(BuildingSearchRequest params);
}
