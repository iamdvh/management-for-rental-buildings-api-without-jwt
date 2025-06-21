package com.iamdvh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
@PropertySource("classpath:application.properties")
public class ConnectionUtil {
	private static String db_url = "jdbc:mysql://localhost:3306/estatebasic";
	private static String user = "root";
	private static String password = "root";
	@Value("${spring.datasource.url}")
	private static String dbUrl;
	@Value("${spring.datasource.username}")
	private static String username;
	@Value("${spring.datasource.password}")
	private static String pw;
	
	public static Connection getConnection() {
		Connection con = null;
		try {
//			con = DriverManager.getConnection(db_url, user, password);
			con = DriverManager.getConnection(dbUrl, username, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
