package com.iamdvh.repository;

import com.iamdvh.repository.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    List<RentAreaEntity> findByBuilding_Id(Long buildingId);
}
