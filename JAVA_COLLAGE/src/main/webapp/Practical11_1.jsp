<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practical 11_1</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		session.setAttribute("name", name);
	%>
	Session Created Successfully
	<a href="Practical11_2.jsp">Click Here</a>
</body>
</html>

