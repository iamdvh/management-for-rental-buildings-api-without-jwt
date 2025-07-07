package com.iamdvh.api;

import java.util.ArrayList;
import java.util.List;

import com.iamdvh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamdvh.dto.UserDTO;

@RestController
public class UserAPI {
	@Autowired
	private UserService userService;
	@GetMapping("/api/staff")
	public List<UserDTO> getStaffs(@RequestParam(value = "buildingid") Long buildingId) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		return result;
	}

	@GetMapping("/api/users")
	public List<UserDTO> getUsers(@RequestParam(value = "roleCode", required = false) String roleCode) {
		return userService.findByRole(roleCode);
	}
}
