package com.yp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yp.model.CarDetailsFetcher;

@WebServlet("/DisplayAllCars")
public class DisplayAllCarsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// write the logic to fetch the data from the database and which is returns the
		// ResultSet

		ResultSet rs = CarDetailsFetcher.fetchAllCars();
		System.out.println("rs::::::::::::::::::::::::" + rs);

		// set the attribute --> rs-> cars
		req.setAttribute("cars", rs);

		// forward to the display page with the data or rs or the records
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, resp);

	}

}
