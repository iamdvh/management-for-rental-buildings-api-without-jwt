package com.iamdvh.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.bean.BuildingBean;

@RestController
public class BuildingApi {
	@GetMapping("/api/building")
	public @ResponseBody List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "numberofbasement", required = false) String numberofbasement,
			@RequestParam(value = "types", required = false) String[] types) {
		System.out.println("name: " + name);
		System.out.println("numberofbasement" + numberofbasement);
		System.out.println("types: " + types);
		return null;
	}

	@GetMapping("/api/building/{buildingId}")
	public @ResponseBody List<BuildingBean> getDetail(@PathVariable String buildingId) {
		return null;
	}

	@PostMapping("/api/building")
	public @ResponseBody List<BuildingBean> createBuilding(@RequestBody BuildingBean request) {
		return null;
	}

	@PutMapping("/api/building")
	public @ResponseBody List<BuildingBean> updateBuilding(@RequestBody BuildingBean request) {
		return null;
	}

	@DeleteMapping("/api/building")
	public void deleteBuilding(@RequestBody Long[] ids) {
		System.out.println(ids.toString());
	}
}
