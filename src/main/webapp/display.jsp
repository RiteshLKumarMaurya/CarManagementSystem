<%@page import="java.sql.Blob"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="java.awt.Image"%>
<%@page import="com.mysql.cj.jdbc.result.CachedResultSetMetaDataImpl"%>
<%@page import="com.yp.model.CarDetailsFetcher"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<%!
	String image=null;
	ResultSet cars=null;
	%>
	
	<%

	cars=CarDetailsFetcher.fetchAllCars();
	
	
	%>
	<h2>All Cars Details:-</h2>

	<table border="1">
	<tr>
		<th>carId</th>
		<th>carModel</th>
		<th>carBrand</th>
		<th>carColor</th>
		<th>carPrice</th>
		<th>carImage</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
			<%
				while(cars.next()){
				Blob blob=cars.getBlob("carImage");
				if(blob!=null){
				byte imgStream[]=blob.getBytes(1, (int)blob.length());
				//---
				image=Base64.getEncoder().encodeToString(imgStream);
			%>
		
		
			<tr>
				<td><%=cars.getInt("carId") %></td>
				<td><%=cars.getString("carModel") %></td>
				<td><%=cars.getString("carBrand") %></td>
				<td><%=cars.getString("carColor") %></td>
				<td><%=cars.getInt("carPrice") %></td>
				<td><img style="height: 60px" alt="uploaded image" src="data:image/*;base64,<%=image%>"></td>
				<td><a href="update?carId=<%=cars.getInt("carId")%>"><button style="background: blue; color: white;">Update</button></a></td>			
				<td><a href="delete?carId=<%=cars.getInt("carId")%>"><button style="background: red; color: white;">Delete</button></a></td>			
			</tr>
			
	<% 
		}}
		if(cars!=null)cars.close();
	%>
	</table>	

<a href="index.jsp">Go to Home</a>

</body>
</html>