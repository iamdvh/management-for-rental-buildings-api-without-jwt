package com.iamdvh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iamdvh.repository.DistrictRepository;
import com.iamdvh.repository.entity.DistrictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamdvh.converter.BuildingConverter;
import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.dto.response.BuildingSearchResponse;
import com.iamdvh.repository.BuildingRentTypeRepository;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.RentAreaRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingRentTypeRepository buildingRentTypeRepository;
	@Autowired
	private RentAreaRepository areaRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private BuildingConverter buildingConverter;

	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> request, List<String> types) {
		List<BuildingSearchResponse> result = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(request, types);
		for (BuildingEntity item : buildingEntities) {
			BuildingSearchResponse buildingSearchResponse = buildingConverter.convertBuidingEntityToBuildingSearchResponse(item);
			result.add(buildingSearchResponse);
		}
		return result;
	}
	
	
	private String findTypes(Long buildingId) {
		return buildingRentTypeRepository.findByBuildingId(buildingId);
	}
	
	private String findRentAreas(Long buildingId) {
		return areaRepository.findByBuildingId(buildingId);
	}


	@Override
	public BuildingDTO findById(Long buildingId) {
		// TODO Auto-generated method stub
		return null;
	}




}
