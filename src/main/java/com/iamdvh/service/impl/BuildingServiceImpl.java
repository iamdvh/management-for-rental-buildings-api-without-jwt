package com.iamdvh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.iamdvh.converter.RentAreaConverter;
import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.dto.RentAreaDTO;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.RentAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamdvh.dto.response.BuildingSearchResponse;
import com.iamdvh.repository.custom.BuildingRepositoryCustom;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
//	private BuildingJdbc buildingJdbc;
//	private BuildingRepositoryCustom buildingRepository;
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaConverter rentAreaConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;

    //	@Override
//	public List<BuildingSearchResponse> findAll() {
//		List<BuildingSearchResponse> result = new ArrayList<>();
//		List<BuildingEntity> buildingEntities = buildingJdbc.findAll();
//		for (BuildingEntity item : buildingEntities) {
//			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
//			buildingSearchResponse.setName(item.getName());
//			buildingSearchResponse.setAddress(item.getStreet() + " " +item.getWard());
//			result.add(buildingSearchResponse);
//		}
//		return result;
//	}
    @Override
    public List<BuildingSearchResponse> findAll() {
        List<BuildingSearchResponse> result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
            buildingSearchResponse.setName(item.getName());
            buildingSearchResponse.setAddress(item.getStreet() + " " + item.getWard());
            result.add(buildingSearchResponse);
        }
        return result;
    }

    @Override
    public List<RentAreaDTO> findRentAreasByBuildingId(Long buildingId) {
//		BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
//        List<RentAreaDTO> results = buildingEntity.getRentAreas().stream().map(
//                r -> rentAreaConverter.toDto(r)
//        ).collect(Collectors.toList());
        List<RentAreaDTO> results = rentAreaRepository.findByBuilding_Id(buildingId)
                .stream()
                .map(r -> rentAreaConverter.toDto(r))
                .collect(Collectors.toList());
        return results;
    }

    @Override
    public void save(BuildingDTO buildingDTO) {

//		buildingRepository.save(buildingDTO);
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingRepository.save(buildingEntity);

    }
}
