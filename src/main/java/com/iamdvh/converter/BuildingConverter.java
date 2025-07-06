package com.iamdvh.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.dto.response.BuildingSearchResponse;
import com.iamdvh.repository.DistrictRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.repository.entity.DistrictEntity;

@Component
public class BuildingConverter {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	DistrictRepository districtRepository;
	
	public BuildingSearchResponse convertBuidingEntityToBuildingSearchResponse(BuildingEntity buildingEntity) {
		// convert 8 fields
		BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
		DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistricId());
		buildingSearchResponse.setAddress(buildingEntity.getStreet() + " - " +buildingEntity.getWard() + " - " +districtEntity.getName());
		return buildingSearchResponse;
	}
	public BuildingDTO convertBuildingEntityToBuildingDTO(BuildingEntity buildingEntity) {
		BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
		return buildingDTO;
	}
}
