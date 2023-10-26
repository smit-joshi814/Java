<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practical 9</title>
</head>
<body>
	<form action="" method="POST">
		<input type="number" name="sno" placeholder="Enter sno" /><br /> <input
			type="text" name="sname" placeholder="Enter sname" /><br /> <input
			type="submit" value="Insert" name="btn" /> <input type="submit"
			value="Update" name="btn" /> <input type="submit" value="Delete"
			name="btn" /> <input type="submit" value="Select" name="btn" />
	</form>
	<%!PreparedStatement ps;
	ResultSet rs;%>
	<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "JAVA_APP", "SMIT12#");

		if (request.getParameter("sno") != null) {
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			if (request.getParameter("btn").equals("Insert")) {
		ps = cn.prepareStatement("INSERT INTO tblStudents VALUES(?,?)");
		ps.setString(1, sno);
		ps.setString(2, sname);
		ps.execute();
		out.print("Record Inserted Successfully");
			} else if (request.getParameter("btn").equals("Update")) {
		ps = cn.prepareStatement("UPDATE tblStudents SET sname=? WHERE sno=?");
		ps.setString(2, sno);
		ps.setString(1, sname);
		ps.execute();
		out.print("Record Updated Successfully");
			} else if (request.getParameter("btn").equals("Delete")) {
		ps = cn.prepareStatement("DELETE FROM tblStudents WHERE sno=?");
		ps.setString(1, sno);
		ps.execute();
		out.print("Record Deleted Successfully");
			} else if (request.getParameter("btn").equals("Select")) {
		ps = cn.prepareStatement("SELECT * FROM tblStudents");
		rs = ps.executeQuery();
	%>
	<table>
		<thead>
			<tr>
				<th>sno</th>
				<th>sname</th>
			</tr>
		</thead>
		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>


	<%
	}
	}
	} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
	}
	%>
</body>
</html>