package com.iamdvh.repository;

import com.iamdvh.repository.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findById(Long districtId);

}
