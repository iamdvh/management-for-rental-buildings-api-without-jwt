package com.iamdvh.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;
@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<BuildingEntity> findAll() {
		// JPQL
//		String sql = "FROM BuildingEntity";
//		Query query = entityManager.createQuery(sql, BuildingEntity.class);
		// Native query
		String sql = "select * from building";
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
	}


	@Override
	public BuildingEntity findById(Long buildingId) {
		String sql = "select * from building where id = "+ buildingId;
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return (BuildingEntity) query.getSingleResult();
	}

}
