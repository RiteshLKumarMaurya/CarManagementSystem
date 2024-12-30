package com.yp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDetailDelete {
	public static boolean deleteCarUsingId(int carId) {
		boolean flag = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=ghost$fuck$love");
			PreparedStatement pst = conn.prepareStatement("delete from cars where carId=?");
			pst.setInt(1, carId);
			flag = pst.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
