package com.iamdvh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	private static String db_url = "jdbc:mysql://localhost:3306/estatebasic";
	private static String user = "root";
	private static String password = "root";

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(db_url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
