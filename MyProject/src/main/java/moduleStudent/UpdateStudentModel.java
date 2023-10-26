package moduleStudent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conPkg.ConnectionProvider;

/**
 * Servlet implementation class UpdateStudentModel
 */
@WebServlet("/UpdateStudentModel")
public class UpdateStudentModel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentModel() {
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
			String sname = request.getParameter("mdlstudent");
			String address = request.getParameter("mdladdress");
			int pay = Integer.parseInt(request.getParameter("mdladvPay"));
			String sid = request.getParameter("hdnsid");
			int paid = Integer.parseInt(request.getParameter("hdnpaid"));
			int due = Integer.parseInt(request.getParameter("mdlhdnpay"));

			if (pay > due) {
				out.print("<p class='text-danger'>Invalid Pay Value</p>");
				return;
			} else {
				paid += pay;
				due -= pay;
			}

			Connection cn = ConnectionProvider.getCon();
			PreparedStatement ps = cn.prepareStatement(
					"UPDATE `student` SET `address`=?,`Fees_Paid`=?,`Fees_due`=?,`student_name`=? WHERE student_id=?");
			ps.setString(1, address);
			ps.setInt(2, paid);
			ps.setInt(3, due);
			ps.setString(4, sname);
			ps.setString(5, sid);
			ps.execute();
			out.print("<p class='text-success'>Updated SuccessFully</p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
