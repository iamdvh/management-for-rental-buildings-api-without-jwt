package com.iamdvh.service.impl;

import com.iamdvh.converter.UserConverter;
import com.iamdvh.dto.UserDTO;
import com.iamdvh.repository.custom.RoleRepositoryCustom;
import com.iamdvh.repository.custom.UserRepositoryCustom;
import com.iamdvh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepositoryCustom roleRepository;
    @Autowired
    private UserRepositoryCustom userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> findByRole(String roleCode) {
//        RoleEntity role = roleRepository.findByCode(roleCode);
//        List<UserDTO> results =  role.getUsers()
//                .stream()
//                .map(u -> userConverter.toDTO(u))
//                .collect(Collectors.toList());
        List<UserDTO> results = userRepository.findByRole(roleCode)
                .stream()
                .map(u -> userConverter.toDTO(u))
                .collect(Collectors.toList());
        return results;
    }
}
