package com.iamdvh.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iamdvh.repository.RentAreaRepository;
import com.iamdvh.utils.CheckUtil;
import com.iamdvh.utils.ConnectionUtil;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
	@Override
	public String findByBuildingId(Long buildingId) {
		List<String> rentAreas = new ArrayList<>();
		String query = "select r.value from rentarea r ";
		if(!CheckUtil.isNull(buildingId)) {
			query += " where r.buildingid = "+buildingId;
		}
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				rentAreas.add(Integer.toString(rs.getInt("value")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.join(", ", rentAreas);
	}

}
