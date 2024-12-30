package com.yp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yp.model.CarDetailUpdator;

@WebServlet("/save-discard")
public class SaveDiscardServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int carId=Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		String carColor=req.getParameter("carColor");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));
		
		//save to the d.b..
		boolean res=CarDetailUpdator.updateCar(carId, carModel, carBrand, carColor, carPrice);
		if(res) {
			//send to the success page 
//			resp.sendRedirect("success.jsp");
			try {
				new Thread().sleep(3000);
				resp.sendRedirect("DisplayAllCars");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		else {
			//send to the error page
		
			resp.sendRedirect("error.jsp");
		}
		
	
	}

}
