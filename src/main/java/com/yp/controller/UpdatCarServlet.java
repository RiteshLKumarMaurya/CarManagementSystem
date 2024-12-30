package com.yp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yp.model.CarDetailsFetcher;

@WebServlet("/update")
public class UpdatCarServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carId"));
		
		ResultSet rs=CarDetailsFetcher.fetchSingleCar(carId);
		
		req.setAttribute("car", rs);
		
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
		
	}

}
