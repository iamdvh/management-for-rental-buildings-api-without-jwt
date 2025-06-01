package com.iamdvh.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.dto.UserDTO;

@RestController
public class UserAPI {
	@GetMapping("/api/staff")
	public List<UserDTO> getStaffs(@RequestParam(value = "buildingid") Long buildingId) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		return result;
	}

	@GetMapping("/api/users")
	public List<UserDTO> getUsers(@RequestParam(value = "buildingid", required = false) Long buildingId,
			@RequestParam(value = "role", required = false) String roleCode) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		return result;
	}
}
