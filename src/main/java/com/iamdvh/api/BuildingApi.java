package com.iamdvh.api;

import java.util.ArrayList;
import java.util.List;

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

import com.iamdvh.bean.AssignmentBuildingBean;
import com.iamdvh.bean.BuildingBean;
import com.iamdvh.bean.ErrorResponseBean;
import com.iamdvh.exception.FieldRequiredException;

@RestController
@RequestMapping("/api/building")
public class BuildingApi {
	@GetMapping
	public @ResponseBody List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "numberofbasement", required = false) String numberofbasement,
			@RequestParam(value = "types", required = false) String[] types) {
		List<BuildingBean> result = new ArrayList<BuildingBean>();
		return result;
	}

	@GetMapping("/{buildingId}")
	public @ResponseBody List<BuildingBean> getDetail(@PathVariable String buildingId) {
		return null;
	}

//	@PostMapping("/api/building")
//	public @ResponseBody List<BuildingBean> createBuilding(@RequestBody BuildingBean request) {
//		System.out.println(10/0);
//		return null;
//	}
	
	@PostMapping
	public Object createBuilding(@RequestBody BuildingBean newBuilding) {
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
		System.out.println(10/0);
		return newBuilding;
	}

	@PutMapping
	public Object updateBuilding(@RequestBody BuildingBean updateBuilding) {
		validateData(updateBuilding);
		return updateBuilding;
	}

	@DeleteMapping
	public void deleteBuilding(@RequestBody Long[] ids) {
		System.out.println(ids.toString());
	}	
	
	@PostMapping("/assignment")
	public void assignmentBuilding(@RequestBody AssignmentBuildingBean assignmentBuildingBean) {
		
	}
	
	private void validateData(BuildingBean building){
		if(building.getName() == null 
				|| !building.getName().isEmpty() 
				|| building.getFloorArea() == null 
				|| building.getNumberOfBasement() == null) {
			throw new FieldRequiredException("Fields are required");
		}
	}
}
