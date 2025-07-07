package com.iamdvh.repository.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.iamdvh.repository.entity.DistrictEntity;
import org.springframework.stereotype.Repository;

import com.iamdvh.contant.SystemContant;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.utils.CheckUtil;
import com.iamdvh.utils.ConnectionUtil;
import com.iamdvh.utils.MapUtil;
import com.iamdvh.utils.NumberUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> types) {
		StringBuilder sql =  new StringBuilder("SELECT * FROM building ");
		sql = buildingJoining(params, types, sql);
		sql.append(SystemContant.ONE_EQUAL_ONE);
		sql = buildingCommon(params, types, sql);
		sql = buidingSpeciel(params, types, sql);
		sql.append(" GROUP BY b.id");
		return null;
	}

	

	private StringBuilder buildingJoining(Map<String, Object> params, List<String> types, StringBuilder sql) {
		sql.append(" inner join district as d on d.id = b.districtid");
		
		Long staffId = params.containsKey("staffid") ? params.get("staffid").equals("") ? null : Long.valueOf(params.get("staffid").toString()):null;
		
		if(staffId != null) {
			sql.append(" inner join assignmentbuilding as ab on ab.id = b.staffid");
		}
		if(types.size()>0) {
			
		}
		return sql;
	}

	private StringBuilder buildingCommon(Map<String, Object> params, List<String> types, StringBuilder sql) {
//		String name = MapUtil.getObject(params, "name", String.class);
//		String street = MapUtil.getObject(params, "street", String.class);
//		int floorArea = MapUtil.getObject(params, "floorarea", Integer.class);
//		int numberOfBasement = MapUtil.getObject(params, "numberofbasement", Integer.class);
		
		for(Map.Entry<String, Object> item : params.entrySet()) {
			if(!item.getKey().equals("types") 
					&& !item.getKey().equals("districtid")
					&& !item.getKey().equals("staffid")
					&& !item.getKey().startsWith("rentarea")
					&& !item.getKey().startsWith("costrent")
					) {
				String value = item.getValue().toString();
				if(NumberUtil.isInteger(value)) {
					sql.append(" b."+item.getKey().toLowerCase()+" = "+Integer.parseInt(value)+"");
				} else {
					if(!CheckUtil.isNullOrEmpty(value)) {
						sql.append(" b."+item.getKey().toLowerCase()+" like '%"+value+"%'");
					}
					
				}
			}
		}
		return sql;
	}
	
	
	private StringBuilder buidingSpeciel(Map<String, Object> params, List<String> types, StringBuilder sql) {
		Integer costRentFrom = MapUtil.getObject(params, "costrentfrom", Integer.class);
		Integer costRentTo = MapUtil.getObject(params, "costrentto", Integer.class);
		Integer rentAreaFrom = MapUtil.getObject(params, "rentareafrom", Integer.class);
		Integer rentAreaTo = MapUtil.getObject(params, "rentareato", Integer.class);

		if (costRentFrom != null) {
		    sql.append(" and b.costrent >= " + costRentFrom + " ");
		}

		if (costRentTo != null) {
		    sql.append(" and b.costrent <= " + costRentTo + " ");
		}

		if (rentAreaFrom != null || rentAreaTo != null) {
		    sql.append(" and EXISTS (SELECT value FROM rentarea as ra WHERE b.id = ra.buildingid");
		    if (rentAreaFrom != null) {
		        sql.append(" and ra.value >= " + rentAreaFrom + " ");
		    }
		    if (rentAreaTo != null) {
		        sql.append(" and ra.value <= " + rentAreaTo + " ");
		    }
		    sql.append(") ");
		}
//		javab7
//		if(types != null && types.size() > 0) {
//			sql.append(" and (");
//			List<String> tempType = new ArrayList<>();
//			for(String type: types) {
//				tempType.add(" rt.code = '"+type+"'");
//			}
//			String sqlJoin = String.join(" or ", tempType);
//			sql.append(sqlJoin + ")");
//		}

//		java 8
		if(types.size()>0 && types != null) {
			sql.append(" and (");
			List<String> tempType = new ArrayList<>();
			String sqlJoining =  types.stream().map(type -> {
				return " rt.code = '"+type+"'";
			}).collect(Collectors.joining(" or "));
			sql.append(sqlJoining);
			sql.append(" ) ");
		}
		return sql;
	}


	@Override
	public BuildingEntity findById(Long buildingId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
