package com.iamdvh.service;

import java.util.List;
import java.util.Map;

import com.iamdvh.dto.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findAll(Map<String, Object> buildingSearch, String[] types);
	List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> types);
	
}
