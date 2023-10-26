<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practical 10</title>
</head>
<body>
	<form>
		<input type="number" name="no" /> <input type="submit" name="btn"
			value="Find Factorial" />
	</form>
	<%!int i;%>
	<%
	if (request.getParameter("btn") != null) {
		int no = Integer.parseInt(request.getParameter("no"));
		int ans=1;
		for (int i = 1; i <= no; i++) {
			ans *= i;
		}
	%>
	Factorial for <%=no%> is <b><%=ans%></b>
	<%
	}
	%>

</body>
</html>