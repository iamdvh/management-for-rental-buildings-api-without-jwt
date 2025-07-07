package com.iamdvh.repository.custom.impl;

import com.iamdvh.repository.custom.RentAreaRepositoryCustom;
import com.iamdvh.repository.entity.RentAreaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<RentAreaEntity> findByBuildingId(Long buildingId) {
        // JPQL
        String sql = "FROM RentAreaEntity WHERE building.id = " + buildingId +"";
        Query query = entityManager.createQuery(sql, RentAreaEntity.class);
        return query.getResultList();
    }
}
