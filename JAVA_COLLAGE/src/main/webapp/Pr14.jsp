<jsp:useBean id="lan" class="pr14.Bean" scope="page"/>
<jsp:setProperty property="*" name="lan" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practical 14</title>
</head>
<body>
Your Favorite Language is : <jsp:getProperty property="language" name="lan"/><br/>
Your Favorite Language is : <%=lan.getLanguage() %>
</body>
</html>