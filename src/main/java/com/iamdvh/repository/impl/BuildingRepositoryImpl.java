package com.iamdvh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Repository;

import com.iamdvh.constant.SystemContant;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;
import com.iamdvh.utils.CheckUtil;
import com.iamdvh.utils.ConnectionUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, String[] types) {
		StringBuilder whereQuery = new StringBuilder();
		StringBuilder joinQuery = new StringBuilder();
		StringBuilder finalQuery = new StringBuilder(
				"select distinct b.id , b.name , b.street , b.ward, b.districtid , b.numberofbasement , b.floorarea , b.rentprice, b.servicefee, b.brokeragefee"
		);
		buildNormalQuery(params, whereQuery);
		builSpecialQuery(params, types, joinQuery, whereQuery, finalQuery);
		finalQuery.append(" from building b");
		
		finalQuery.append(joinQuery).append(SystemContant.ONE_EQUAL_ONE).append(whereQuery);
		
		String fQuery = finalQuery.toString();
		List<BuildingEntity> result = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(finalQuery.toString());) {
			System.out.println("Connected database successfully...");

			while (rs.next()) {
				BuildingEntity buidingEntity = new BuildingEntity();
				buidingEntity.setId(rs.getLong("id"));
				buidingEntity.setName(rs.getString("name"));
				buidingEntity.setWard(rs.getString("ward"));
				buidingEntity.setStreet(rs.getString("street"));
				buidingEntity.setDistricId(rs.getLong("districtid"));
				buidingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
				buidingEntity.setFloorArea(rs.getInt("floorarea"));
				buidingEntity.setRentPrice(rs.getInt("rentprice"));
				buidingEntity.setServiceFee(rs.getInt("servicefee"));
				buidingEntity.setBrokerageFee(rs.getInt("brokeragefee"));
				result.add(buidingEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private void buildNormalQuery(Map<String, Object> params, StringBuilder whereQuery) {
		String name = (String) params.get("name");
		String street = (String) params.get("street");
		String ward = (String) params.get("ward");
		Long floorArea = (Long) params.get("floorArea");
		Integer numberOfBasement = (Integer) params.get("numberOfBasement");
		String direction = (String) params.get("direction");
		String level = (String) params.get("level");
		Integer rentPriceTo = (Integer) params.get("rentPriceTo");
		Integer rentPriceFrom = (Integer) params.get("rentPriceFrom");

		if (!CheckUtil.isNullOrEmpty(name)) {
			whereQuery.append(" and b.name like '%" + name + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(street)) {
			whereQuery.append(" and b.street like '%" + street + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(ward)) {
			whereQuery.append(" and b.ward like '%" + ward + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(direction)) {
			whereQuery.append(" and b.direction like '%" + direction + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(level)) {
			whereQuery.append(" and b.level like '%" + level + "%'");
		}

		if (!CheckUtil.isNull(floorArea)) {
			whereQuery.append(" and b.floorArea = " + floorArea + "");
		}

		if (!CheckUtil.isNull(numberOfBasement)) {
			whereQuery.append(" and b.numberofbasement = " + numberOfBasement + "");
		}

		if (!CheckUtil.isNull(rentPriceFrom) || !CheckUtil.isNull(rentPriceTo)) {
			if (!CheckUtil.isNull(rentPriceFrom) && !CheckUtil.isNull(rentPriceTo)) {
				whereQuery.append(" and b.rentprice between " + rentPriceFrom + " and " + rentPriceTo + "");
			} else if (!CheckUtil.isNull(rentPriceFrom)) {
				whereQuery.append(" and b.rentprice >= " + rentPriceFrom + "");
			} else {
				whereQuery.append(" and b.rentprice <= " + rentPriceTo + "");
			}
		}
		
	}

	private void builSpecialQuery(Map<String, Object> params, String[] types, StringBuilder joinQuery, StringBuilder whereQuery, StringBuilder finalQuery) {
		String districtCode = (String) params.get("districtCode");
		Integer rentAreaFrom = (Integer) params.get("rentAreaFrom");
		Integer rentAreaTo = (Integer) params.get("rentAreaTo");
		Long staffId = (Long) params.get("staffId");
		
		
		if(!CheckUtil.isNullOrEmpty(districtCode)){
			joinQuery.append(" join district d on b.districtid = d.id");
			whereQuery.append(" and d.code = '"+districtCode+"'");
		}
		
		if(types.length > 0) {
			joinQuery.append(" join buildingrenttype t on t.buildingid = b.id join renttype rt on t.renttypeid = rt.id");
			List<String> pretype = new ArrayList<>();
			for(String item : types) {
				pretype.add("'"+item+"'");
			}
			String queryType = String.join(", ", pretype);
			whereQuery.append(" and rt.code in ("+queryType+")");
		}
		
		if (!CheckUtil.isNull(rentAreaFrom) || !CheckUtil.isNull(rentAreaTo)) {
			
			joinQuery.append(" join rentarea ra on ra.buildingid = b.id");
			
			if (!CheckUtil.isNull(rentAreaFrom) && !CheckUtil.isNull(rentAreaTo)) {
				whereQuery.append(" and ra.value between " + rentAreaFrom + " and " + rentAreaTo + "");
			} else if (!CheckUtil.isNull(rentAreaFrom)) {
				whereQuery.append(" and ra.value >= " + rentAreaFrom + "");
			} else {
				whereQuery.append(" and ra.value <= " + rentAreaTo + "");
			}
		}
		
		if(!CheckUtil.isNull(staffId)) {
			joinQuery.append(" join assignmentbuilding ab on b.id = ab.buildingid join user u on ab.staffid = u.id");
			whereQuery.append(" and ab.staffid = "+staffId+"");
		}
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> types) {
		String query = "select * from building where 1 = 1 ";
		
		return null;
	}

}
