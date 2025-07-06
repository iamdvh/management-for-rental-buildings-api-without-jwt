package com.iamdvh.repository.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iamdvh.repository.entity.DistrictEntity;
import org.springframework.stereotype.Repository;

import com.iamdvh.contant.SystemContant;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.utils.CheckUtil;
import com.iamdvh.utils.ConnectionUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> types) {
		StringBuilder sql =  new StringBuilder("SELECT * FROM building ");
		sql.append(SystemContant.ONE_EQUAL_ONE);
		String name = (String) params.get("name");
		int floorArea = params.containsKey("floorarea") ? params.get("floorarea").equals("") ? null : Integer.valueOf(params.get("floorarea").toString()):null;
		Long staffId = params.containsKey("staffid") ? params.get("staffid").equals("") ? null : Long.valueOf(params.get("staffid").toString()):null;
		
		return null;
	}

	@Override
	public BuildingEntity findById(Long buildingId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
