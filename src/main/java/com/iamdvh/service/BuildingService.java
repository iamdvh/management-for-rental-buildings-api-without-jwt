package com.iamdvh.service;

import java.util.List;

import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.dto.RentAreaDTO;
import com.iamdvh.dto.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findAll();
	List<RentAreaDTO> findRentAreasByBuildingId(Long buildingId);
	void save(BuildingDTO buildingDTO);
}
