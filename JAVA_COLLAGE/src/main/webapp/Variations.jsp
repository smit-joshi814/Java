<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="getVar" method="POST">
		<select name="size">
			<option>S</option>
			<option>M</option>
			<option>L</option>
		</select>
		<select name="color">
			<option>Red</option>
			<option>Green</option>
			<option>Blue</option>
		</select>
		<select name="capacity">
			<option>100GB</option>
			<option>256GB</option>
			<option>512GB</option>
		</select><br/>
		<input type="submit" value="submit" />
	</form>
</body>
</html>