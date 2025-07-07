package com.iamdvh.converter;

import com.iamdvh.dto.BuildingDTO;
import com.iamdvh.repository.entity.BuildingEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;
    public BuildingEntity toEntity (BuildingDTO dto) {
        return modelMapper.map(dto, BuildingEntity.class);
    }
}
