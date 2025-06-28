package com.iamdvh.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.dto.RentAreaDTO;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.repository.entity.RentAreaEntity;

@RestController
public class RentAreaApi {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@GetMapping("/api/rent-areas")
	public List<RentAreaDTO> getRentAreas (@RequestParam(value = "buildingid", required = false) Long buildingId) {
		BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
		List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreas();
		for (RentAreaEntity item : rentAreaEntities) {
			System.out.println(item.getValue());
		}
		return null;
	}

}
