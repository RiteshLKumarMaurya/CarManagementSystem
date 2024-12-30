package com.yp.controller;

import java.io.IOException;
import java.util.logging.Handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yp.model.CarDetailDelete;

@WebServlet("/delete")
public class DeleteCarServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//just we need to call the method of the dao to perform the deletion operation using --> id
	
		int carId=Integer.parseInt(req.getParameter("carId"));
		boolean deleted=CarDetailDelete.deleteCarUsingId(carId);
		if(deleted) {
			//send to the success
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
