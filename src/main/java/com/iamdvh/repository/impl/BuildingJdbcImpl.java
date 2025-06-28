package com.iamdvh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.iamdvh.repository.BuildingJdbc;
import com.iamdvh.repository.BuildingRepository;
import com.iamdvh.repository.entity.BuildingEntity;

@Repository
@PropertySource("classpath:application.properties")
public class BuildingJdbcImpl implements BuildingJdbc {
//	private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
//	private String USER = "root";
//	private String PASS = "root";
	@Value("${spring.datasource.url}")
	private String DB_URL;
	@Value("${spring.datasource.username}")
	private String USER;
	@Value("${spring.datasource.password}")
	private String PASS;
	

	@Override
	public List<BuildingEntity> findAll() {
		String query = "SELECT * FROM building";
		List<BuildingEntity> result = new ArrayList<>();
		/*
		 * try catch with resource
		 * 
		 * */
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			System.out.println("Connected database successfully...");
			
			while (rs.next()) {
				BuildingEntity buidingEntity = new BuildingEntity();
				buidingEntity.setName(rs.getString("name"));
				buidingEntity.setWard(rs.getString("ward"));
				buidingEntity.setStreet(rs.getString("street"));
				buidingEntity.setDistricId(rs.getLong("districtId"));
				result.add(buidingEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		return result;
	}

}
