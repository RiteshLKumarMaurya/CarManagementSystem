package com.yp.model;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDetailsFetcher {
	
	public static ResultSet fetchAllCars() {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=ghost$fuck$love");
			
			//3.
			pst=conn.prepareStatement("select * from cars");
			
			//4
			rs=pst.executeQuery();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
//				conn.close();---?> what is this is this same as the closing the resource--> check do and donot
				if(pst!=null)pst=null;
				if(conn!=null)conn=null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("rs:@@@@@@@@@@: "+rs);
		return rs;
		
	}

	

	public static ResultSet fetchSingleCar(int carId) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=ghost$fuck$love");
			
			//3.
			pst=conn.prepareStatement("select * from cars where carId=?");
			pst.setInt(1, carId);
			
			//4
			rs=pst.executeQuery();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
//				conn.close();---?> what is this is this same as the closing the resource--> check do and donot
				if(pst!=null)pst=null;
				if(conn!=null)conn=null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("rs:@@@@@@@@@@: "+rs);
		return rs;
		
	}

}
