package com.iamdvh.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.iamdvh.repository.custom.BuildingRepositoryCustom;
import com.iamdvh.repository.entity.BuildingEntity;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
//	@PersistenceContext
//	private EntityManager entityManager;
//
//
//	@Override
//	public List<BuildingEntity> findAll() {
//		// JPQL
////		String sql = "FROM BuildingEntity";
////		Query query = entityManager.createQuery(sql, BuildingEntity.class);
//		// Native query
//		String sql = "select * from building";
//		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
//		return query.getResultList();
//	}
//
//
//	@Override
//	public BuildingEntity findById(Long buildingId) {
//		String sql = "select * from building where id = "+ buildingId;
//		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
//		return (BuildingEntity) query.getSingleResult();
//	}
//
//	@Override
//	@Transactional
//	public void save(BuildingEntity newBuilding) {
//		if (newBuilding.getId() == null) {
//			entityManager.persist(newBuilding);
//		}else {
//			entityManager.merge(newBuilding);
//		}
//	}
//
//	@Override
//	@Transactional
//	public void delete(BuildingEntity buildingEntity) {
//		entityManager.remove(buildingEntity);
//	}
}
