<%@page import="com.yp.model.CarDetailsFetcher"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
	margin: 4px;
}
</style>
</head>
<body>
	<%!
		ResultSet car=null;
	%>
	
	<%
		car=(ResultSet) request.getAttribute("car");
	%>
	
	<%
		if(car.next()){
	%>
		<form action="save-discard">
			<h2>Update Your Car Details: </h2>
			<br>
			
			<label>carId: </label>
			<h2><%=car.getInt("carId") %></h2>
			
			<label>carModel: </label>		
			<input value="<%=car.getString("carModel") %>" name="carModel"><br>
			
			
			<label>carBrand: </label>		
			<input value="<%=car.getString("carBrand") %>" name="carBrand"><br>
			
			
			<label>carColor: </label>		
			<input value="<%=car.getString("carColor") %>" name="carColor"><br>
			
			<label>carPrice: </label>
			<input value="<%=car.getInt("carPrice") %>" name="carPrice"><br>
			
			<div style="justify-content: space-between; ">
				<input type="submit" value="save changes" style="background: green; color:  white;"> 
				<a href="DisplayAllCars"><input style="background: red; color: white;" value="discard changes"></a>
			</div>
		
		</form>
		
	<%
		}
	%>
	
</body>
</html>