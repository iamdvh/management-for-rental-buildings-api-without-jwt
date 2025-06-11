package com.iamdvh.service;

import java.util.List;
import java.util.Map;

import com.iamdvh.dto.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findAll(Map<String, Object> request, List<String> types);
}
