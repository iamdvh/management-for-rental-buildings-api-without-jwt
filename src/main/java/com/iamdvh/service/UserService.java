package com.iamdvh.service;

import com.iamdvh.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findByRole(String roleCode);
}
