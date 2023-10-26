<%-- 
    Document   : my
    Created on : 26 Apr, 2023, 10:06:14 AM
    Author     : smitj
--%>

<%@page import="beans.MyBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lang" class="beans.MyBean" />
<jsp:setProperty name="lang" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>your Selected Language is <jsp:getProperty property="language" name="lang"/></h3>
    </body>
</html>
