package com.iamdvh.converter;

import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.dto.RentAreaDTO;
import com.iamdvh.repository.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter {
    @Autowired
    ModelMapper modelMapper;
    public RentAreaDTO toDto (RentAreaEntity entity) {
        RentAreaDTO dto = modelMapper.map(entity, RentAreaDTO.class);
        return dto;
    }
}
