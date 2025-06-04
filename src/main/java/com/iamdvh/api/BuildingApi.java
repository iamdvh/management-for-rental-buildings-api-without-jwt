package com.iamdvh.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.dto.request.BuildingAssignmentRequest;
import com.iamdvh.dto.response.BuildingSearchResponse;
import com.iamdvh.exception.FieldRequiredException;
import com.iamdvh.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingApi {
	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public @ResponseBody List<BuildingSearchResponse> findAll(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "ward", required = false) String ward,
			@RequestParam(value = "districtcode", required = false) String districtCode,
			@RequestParam(value = "numberofbasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "level", required = false) String level,
			@RequestParam(value = "rentareafrom", required = false) Integer rentAreaFrom,
			@RequestParam(value = "rentareato", required = false) Integer rentAreaTo,
			@RequestParam(value = "rentpricefrom", required = false) Integer rentPriceFrom,
			@RequestParam(value = "rentpriceto", required = false) Integer rentPriceTo,
			@RequestParam(value = "staffid", required = false) Long staffId,
			@RequestParam(value = "types", required = false) String[] types) {
		Map<String, Object> buildingSearch = new HashMap<String, Object>();
		buildingSearch.put("name", name);
		buildingSearch.put("street", street);
		buildingSearch.put("ward", ward);
		buildingSearch.put("districtCode", districtCode);
		buildingSearch.put("numberOfBasement", numberOfBasement);
		buildingSearch.put("direction", direction);
		buildingSearch.put("level", level);
		buildingSearch.put("rentAreaFrom", rentAreaFrom);
		buildingSearch.put("rentAreaTo", rentAreaTo);
		buildingSearch.put("rentPriceFrom", rentPriceFrom);
		buildingSearch.put("rentPriceTo", rentPriceTo);
		buildingSearch.put("staffId", staffId);
		
		List<BuildingSearchResponse> result = buildingService.findAll(buildingSearch, types);
		return result;
	}

	@GetMapping("/{buildingId}")
	public @ResponseBody List<BuildingDTO> getDetail(@PathVariable String buildingId) {
		return null;
	}

//	@PostMapping("/api/building")
//	public @ResponseBody List<BuildingBean> createBuilding(@RequestBody BuildingBean request) {
//		System.out.println(10/0);
//		return null;
//	}

	@PostMapping
	public Object createBuilding(@RequestBody BuildingDTO newBuilding) {
//		try {
//			System.out.println(10/0);
//			return newBuilding;
//		} catch (Exception e) {
//			ErrorResponseBean errorResponseBean = new ErrorResponseBean();
//			errorResponseBean.setError(e.getMessage());
//			List<String> details = new ArrayList<>();
//			details.add("Anh gì ơi, thế quái nào mà 1 số có thể chia cho 0 được nhỉ.");
//			errorResponseBean.setDetails(details);
//			return errorResponseBean;
//		}
		System.out.println(10 / 0);
		return newBuilding;
	}

	@PutMapping
	public Object updateBuilding(@RequestBody BuildingDTO updateBuilding) {
		validateData(updateBuilding);
		return updateBuilding;
	}

	@DeleteMapping
	public void deleteBuilding(@RequestBody Long[] ids) {
		System.out.println(ids.toString());
	}

	@PostMapping("/assignment")
	public void assignmentBuilding(@RequestBody BuildingAssignmentRequest assignmentBuildingBean) {

	}

	private void validateData(BuildingDTO building) {
		if (building.getName() == null || !building.getName().isEmpty() || building.getFloorArea() == null
				|| building.getNumberOfBasement() == null) {
			throw new FieldRequiredException("Fields are required");
		}
	}
}
