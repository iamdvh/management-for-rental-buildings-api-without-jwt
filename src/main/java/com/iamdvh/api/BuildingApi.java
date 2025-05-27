package com.iamdvh.api;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iamdvh.bean.BuildingBean;

@Controller
public class BuildingApi {
	@RequestMapping(value = "/api/building", method = RequestMethod.GET)
	public @ResponseBody List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "numberofbasement", required = false) String numberofbasement,
			@RequestParam(value = "types", required = false) String[] types) {
		System.out.println("name: " + name);
		System.out.println("numberofbasement" + numberofbasement);
		System.out.println("types: " + types);
		return null;
	}

	@RequestMapping(value = "/api/building/{buildingId}/{testId}", method = RequestMethod.GET)
	public @ResponseBody List<BuildingBean> getDetail(@PathVariable String buildingId) {
		return null;
	}

	@RequestMapping(value = "/api/building", method = RequestMethod.POST)
	public @ResponseBody List<BuildingBean> createBuilding(@RequestBody BuildingBean request) {
		return null;
	}

	@RequestMapping(value = "/api/building", method = RequestMethod.PUT)
	public @ResponseBody List<BuildingBean> updateBuilding(@RequestBody BuildingBean request) {
		return null;
	}

	@RequestMapping(value = "/api/building", method = RequestMethod.DELETE)
	public void deleteBuilding(@RequestBody Long[] ids) {
		System.out.println(ids.toString());
	}
}
