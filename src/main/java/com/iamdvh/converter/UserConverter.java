package com.iamdvh.converter;

import com.iamdvh.dto.UserDTO;
import com.iamdvh.repository.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO toDTO(UserEntity entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
}
