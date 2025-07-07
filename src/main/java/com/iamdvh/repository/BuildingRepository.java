package com.iamdvh.repository;

import com.iamdvh.repository.custom.BuildingRepositoryCustom;
import com.iamdvh.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> , BuildingRepositoryCustom {
}
