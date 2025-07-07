package com.iamdvh.api;

import java.util.List;

import com.iamdvh.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.dto.RentAreaDTO;

@RestController
public class RentAreaApi {
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping("/api/rent-areas")
	public List<RentAreaDTO> findByBuildingId (@RequestParam(value = "buildingid", required = false) Long buildingId) {
		return buildingService.findRentAreasByBuildingId(buildingId);
	}

}
