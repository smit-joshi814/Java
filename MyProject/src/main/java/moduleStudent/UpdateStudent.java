package moduleStudent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conPkg.ConnectionProvider;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String sid = request.getParameter("sid");
			Connection cn = ConnectionProvider.getCon();
			PreparedStatement ps = cn.prepareStatement(
					"select A.*,B.course_name from student A INNER JOIN cources B ON A.course_id=B.course_id where A.student_id=?");
			ps.setString(1, sid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			out.print(
					"<div class='form-floating mb-2'><input type='text' class='form-control' id='mdlstudent' name='mdlstudent' placeholder='course name' value='"
							+ rs.getString("student_name")
							+ "' required> <label	for='mdlstudent'>student Name</label> </div>");
			out.print(
					"<div class='form-floating mb-2'><textarea class='form-control' id='mdladdress' name='mdladdress'	 style='height: 100px' required>"
							+ rs.getString("address")
							+ "</textarea><label for='mdladdress'>student Address</label></div>");
			out.print("<div class='mb-2'>Fees Payable: <label id='mdlpayable'>Fees Payable: " + rs.getString("Fees_due")
					+ "</label> <input type='hidden'	name='mdlhdnpay' id='mdlhdnpay' value='"
					+ rs.getString("fees_due") + "' /></div>");
			out.print(
					"<div class='form-floating mb-2'><input type='number' class='form-control' id='mdladvPay' name='mdladvPay' value='"
							+ rs.getString("Fees_due")
							+ "' onkeyup='checkFee2(this)' required><label for='mdladvPay'>pay</label></div>");
			out.print(
					"<div id='mdlmsgCourse' class='mb-2 bt-2'></div><button class='w-100 btn btn-lg btn-warning' type='submit'>Update Student</button>");
			out.print("<input type='hidden' name='hdnsid' id='hdnsid' value='" + rs.getString("student_id") + "' />");
			out.print("<input type='hidden' name='hdnpaid' id='hdnpaid' value='"+rs.getString("Fees_Paid")+"' />");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
