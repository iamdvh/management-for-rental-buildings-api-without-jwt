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
		List<BuildingEntity> results = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql.toString())) {
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("name"));
				results.add(buildingEntity);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		StringBuilder whereQuery = new StringBuilder();
		StringBuilder joinQuery = new StringBuilder();
		StringBuilder finalQuery = new StringBuilder(
				"select distinct b.createddate, b.managerphone, b.managername, b.id , b.name , b.street , b.ward, b.districtid , b.numberofbasement , b.floorarea , b.rentprice, b.servicefee, b.brokeragefee"
		);
		
		buildNormalQuery(params, whereQuery);
		builSpecialQuery(params, types , joinQuery, whereQuery, finalQuery);
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
				buidingEntity.setManagerName(rs.getString("managername"));
				buidingEntity.setManagerPhone(rs.getString("managerphone"));
				result.add(buidingEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private void buildNormalQuery(Map<String, Object> params, StringBuilder whereQuery) {
		String name = (String) params.get("name") ;
		String street = (String) params.get("street") ;
		String ward = (String) params.get("ward");
		Long floorArea = !CheckUtil.isNullOrEmpty((String) params.get("floorarea")) ? Long.valueOf((String) params.get("floorarea")) : null;
		Integer numberOfBasement = !CheckUtil.isNullOrEmpty((String) params.get("numberofbasement")) ?  Integer.valueOf((String) params.get("numberofbasement")) : null ;
		String direction = (String) params.get("direction");
		String level = (String) params.get("level");
		Integer rentPriceTo = !CheckUtil.isNullOrEmpty((String) params.get("rentpriceto")) ?  Integer.valueOf((String)  params.get("rentpriceto")) : null;
		Integer rentPriceFrom = !CheckUtil.isNullOrEmpty((String) params.get("rentpricefrom")) ? Integer.valueOf((String)  params.get("rentpricefrom")) : null;

		if (!CheckUtil.isNullOrEmpty(name)) {
			whereQuery.append(" and lower(b.name) like '%" + name.toLowerCase() + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(street)) {
			whereQuery.append(" and lower(b.street) like '%" + street.toLowerCase() + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(ward)) {
			whereQuery.append(" and lower(b.ward) like '%" + ward.toLowerCase() + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(direction)) {
			whereQuery.append(" and lower(b.direction) like '%" + direction.toLowerCase() + "%'");
		}

		if (!CheckUtil.isNullOrEmpty(level)) {
			whereQuery.append(" and lower(b.level) like '%" + level.toLowerCase() + "%'");
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

	private void builSpecialQuery(Map<String, Object> params, List<String> types, StringBuilder joinQuery, StringBuilder whereQuery, StringBuilder finalQuery) {
		String districtCode = (String) params.get("districtcode");
		Integer rentAreaFrom = !CheckUtil.isNullOrEmpty((String) params.get("rentareafrom")) ?  Integer.valueOf((String)params.get("rentareafrom") ): null;
		Integer rentAreaTo =!CheckUtil.isNullOrEmpty((String) params.get("rentareato")) ?  Integer.valueOf((String)params.get("rentareato")) : null;
		Long staffId =!CheckUtil.isNullOrEmpty((String) params.get("staffid")) ?  Long.valueOf((String) params.get("staffid")) : null;
		
		
		if(!CheckUtil.isNullOrEmpty(districtCode)){
			joinQuery.append(" join district d on b.districtid = d.id");
			whereQuery.append(" and d.code = '"+districtCode.toLowerCase()+"'");
		}
		
		if(types != null) {
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
	public BuildingEntity findById(Long buildingId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
