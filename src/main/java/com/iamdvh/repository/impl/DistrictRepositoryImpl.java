package com.iamdvh.repository.impl;

import com.iamdvh.repository.DistrictRepository;
import com.iamdvh.repository.entity.DistrictEntity;
import com.iamdvh.utils.ConnectionUtil;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class DistrictRepositoryImpl implements DistrictRepository {
    @Override
    public DistrictEntity findById(Long districtId) {
        String query = "SELECT * FROM district WHERE id = " +districtId + "";
        List<DistrictEntity> results = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                DistrictEntity districtEntity = new DistrictEntity();
                districtEntity.setName(rs.getString("name"));
                districtEntity.setCode(rs.getString("code"));
                districtEntity.setId(rs.getLong("id"));
                results.add(districtEntity);
            }
            return results.size() > 0 ? results.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return null;
    }
}
