package com.iamdvh.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:application.properties")
public class BuildingApi {
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping
	public @ResponseBody List<BuildingSearchResponse> findAll(
			@RequestParam Map<String, Object> request, @RequestParam(value = "types", required = false) List<String> types) {
		List<BuildingSearchResponse> result = buildingService.findAll(request, types);
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
