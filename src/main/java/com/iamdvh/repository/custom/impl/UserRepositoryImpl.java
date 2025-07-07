package com.iamdvh.repository.custom.impl;

import com.iamdvh.repository.custom.UserRepositoryCustom;
import com.iamdvh.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findByRole(String roleCode) {
        String sql = "FROM UserEntity u JOIN u.roles r WHERE r.code = '" + roleCode+"'";
        Query query = entityManager.createQuery(sql, UserEntity.class);
        return query.getResultList();
    }
}
