package com.iamdvh.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.bean.UserBean;

@RestController
public class UserAPI {
	@GetMapping("/api/staff")
	public List<UserBean> getStaffs(@RequestParam(value = "buildingid") Long buildingId) {
		List<UserBean> result = new ArrayList<UserBean>();
		return result;
	}

	@GetMapping("/api/users")
	public List<UserBean> getUsers(@RequestParam(value = "buildingid", required = false) Long buildingId,
			@RequestParam(value = "role", required = false) String roleCode) {
		List<UserBean> result = new ArrayList<UserBean>();
		return result;
	}
}
