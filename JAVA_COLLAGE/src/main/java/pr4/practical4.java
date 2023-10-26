package pr4;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class practical4
 */
@WebServlet("/practical4")
public class practical4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection cn;
	PreparedStatement ps;
    public practical4() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","JAVA_APP","SMIT12#");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			if(request.getParameter("btnInsert")!=null) {
				String sno=request.getParameter("sno");
				String sname=request.getParameter("sname");
				try {
					ps=cn.prepareStatement("INSERT INTO tblStudents Values(?,?)");
					ps.setString(1, sno);
					ps.setString(2, sname);
					ps.execute();
					out.print("Record Insedted Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(request.getParameter("btnUpdate")!=null){
				try {
					String sno=request.getParameter("sno");
					String sname=request.getParameter("sname");
					ps=cn.prepareStatement("UPDATE tblstudents SET sname=? WHERE sno=?");
					ps.setString(1, sname);
					ps.setString(2, sno);
					ps.execute();
					out.print("Record Updated Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(request.getParameter("btnDelete")!=null) {
				String sno=request.getParameter("sno");
				try {
					ps=cn.prepareStatement("DELETE FROM tblstudents WHERE sno=?");
					ps.setString(1, sno);
					ps.execute();
					out.print("record Deleted Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(request.getParameter("btnSelect")!=null) {
				try {
					ps=cn.prepareStatement("SELECT * FROM tblstudents");
					ResultSet rs=ps.executeQuery();
					out.print("<table border='1'><tr><th>sno</th><th>sname</th></tr>");
					while(rs.next()) {
						out.print("<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td></tr>");
					}
					out.print("<table>");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
