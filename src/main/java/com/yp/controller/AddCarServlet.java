package com.yp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@WebServlet("/AddCar") // first the catalina will be search in the web.xml only if not get there then
						// search in all classes
public class AddCarServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("carId"));
		String model = req.getParameter("carModel");
		String brand = req.getParameter("carBrand");
		String color = req.getParameter("carColor");
		int price = Integer.parseInt(req.getParameter("carPrice"));
		Part imgData = req.getPart("carImage");
		InputStream img = imgData.getInputStream();
		try {
			addCar(id, model, brand, color, price, img, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addCar(int id, String model, String brand, String color, int price, InputStream img,

			HttpServletResponse res) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root",
				"ghost$fuck$love");

		PreparedStatement pst = conn.prepareStatement("insert into cars values(?,?,?,?,?,?)");

		pst.setInt(1, id);
		pst.setString(2, model);
		pst.setString(3, brand);
		pst.setString(4, color);
		pst.setInt(5, price);
		pst.setBlob(6, img);

		if (pst.executeUpdate() > 0) {
			res.sendRedirect("index.jsp");
		} else {
			res.getWriter().println("<html><body><h1 style='color:red;'>Error at insertion!</h1></body></html>");
		}

	}
}
