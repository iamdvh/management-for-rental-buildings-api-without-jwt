package com.iamdvh.repository.custom;

import com.iamdvh.repository.entity.RentAreaEntity;

import java.util.List;

public interface RentAreaRepositoryCustom {
    List<RentAreaEntity> findByBuildingId(Long buildingId);
}
