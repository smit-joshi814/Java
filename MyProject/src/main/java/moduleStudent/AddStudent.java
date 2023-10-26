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
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
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
			Connection cn = ConnectionProvider.getCon();

			String sname = request.getParameter("student");
			String address = request.getParameter("address");
			String course = request.getParameter("course");
			int feesPaid = Integer.parseInt(request.getParameter("advPay"));
			int fees = Integer.parseInt(request.getParameter("hdnpay"));
			int FeesDue;
			if (feesPaid > fees) {
				out.print("<p class='text-danger'>Illigal Value In Advance pay Field</p>");
				return;
			} else {
				FeesDue = fees - feesPaid;
			}
			String Reference = request.getParameter("ref");

			PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO STUDENT (student_name,address,Fees_Paid,Fees_due,course_id,Reference) VALUES(?,?,?,?,?,?)");
			ps.setString(1, sname);
			ps.setString(2, address);
			ps.setInt(3, feesPaid);
			ps.setInt(4, FeesDue);
			ps.setString(5, course);
			ps.setString(6, Reference);
			ps.execute();
			out.print("<p class='text-success'> Student Added SuccessFully<p>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
