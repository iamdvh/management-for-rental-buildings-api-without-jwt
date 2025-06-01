package com.iamdvh.service;

import java.util.List;

import com.iamdvh.dto.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findAll();
}
