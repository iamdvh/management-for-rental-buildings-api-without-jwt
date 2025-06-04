package com.iamdvh.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iamdvh.contant.SystemContant;
import com.iamdvh.repository.BuildingRentTypeRepository;
import com.iamdvh.utils.CheckUtil;
import com.iamdvh.utils.ConnectionUtil;

@Repository
public class BuildingRentTypeRepositoryImpl implements BuildingRentTypeRepository {
	@Override
	public String findByBuildingId(Long buildingId) {
		List<String> types = new ArrayList<>();
		String query = "select b.buildingid , r.name from buildingrenttype b join renttype r on b.renttypeid = r.id "+SystemContant.ONE_EQUAL_ONE+"";
		if(!CheckUtil.isNull(buildingId)) {
			query += "and b.buildingid = "+buildingId;
		}
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				types.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.join(", ", types);
	}

}
