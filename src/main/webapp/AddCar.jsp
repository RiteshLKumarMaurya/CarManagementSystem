<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: orange;">---------- Enter Your Car Details ---------</h1>
	<br>

	<form action="AddCar" method="post" enctype="multipart/form-data">
	<input type="number" name="carId" placeholder="Enter CarId" required="required">
	<input type="text" name="carModel" placeholder="Enter CarModel" required="required">
	<input type="text" name="carBrand" placeholder="Enter CarBrand" required="required">
	<input type="text" name="carColor" placeholder="Enter CarColor" required="required">
	<input type="number" name="carPrice" placeholder="Enter CarPrice" required="required"><br>
	<input type="file" name="carImage" placeholder="Choose the car image" required="required"> <br><br>
	<input type="submit" value="Add New Car" style="background: blue; color: white;" required="required">
	</form>

</body>
</html>