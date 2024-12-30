package com.yp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDetailUpdator {
	public static boolean updateCar(int id,String model,String brand,String color,int price) {
		boolean flag=false;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=ghost$fuck$love");
		
		//3.
		PreparedStatement pst=conn.prepareStatement
				("update cars set carModel=?,carBrand=?,carColor=?,carPrice=? where carId=?");
		
		pst.setString(1, model);
		pst.setString(2, brand);
		pst.setString(3, color);
		pst.setInt(4, price);
		pst.setInt(5, id);
		
		flag=pst.executeUpdate()>0;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
