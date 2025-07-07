package com.iamdvh.repository.custom.impl;

import com.iamdvh.repository.custom.RoleRepositoryCustom;
import com.iamdvh.repository.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Repository
public class RoleRepositoryImpl implements RoleRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public RoleEntity findByCode(String code) {
        String sql = "SELECT r FROM RoleEntity r WHERE r.code = '" +code+ "'";
        Query query = entityManager.createQuery(sql, RoleEntity.class);
        return (RoleEntity) query.getSingleResult();
    }
}
