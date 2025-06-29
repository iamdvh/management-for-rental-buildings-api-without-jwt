package com.iamdvh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamdvh.dto.response.BuildingSearchResponse;
import com.iamdvh.repository.BuildingRentTypeRepository;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingRentTypeRepository buildingRentTypeRepository;

	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> buildingSearch, String[] types) {
		List<BuildingSearchResponse> result = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearch, types, "test");
		for (BuildingEntity item : buildingEntities) {
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			buildingSearchResponse.setName(item.getName());
			buildingSearchResponse.setAddress(item.getStreet() + ", " +item.getWard());
			buildingSearchResponse.setFloorArea(item.getFloorArea());
			buildingSearchResponse.setNumberOfBasement(item.getNumberOfBasement());
			buildingSearchResponse.setRentPrice(item.getRentPrice());
			buildingSearchResponse.setServiceFee(item.getServiceFee());
			buildingSearchResponse.setBrokerageFee(item.getBrokerageFee());
			buildingSearchResponse.setTypes(findTypes(item.getId()));
			result.add(buildingSearchResponse);
		}
		return result;
	}
	
	
	private String findTypes(Long buildingId) {
		return buildingRentTypeRepository.findByBuildingId(buildingId);
	}


	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> types) {
		buildingRepository.findAll(params, types);
		return null;
	}

}
