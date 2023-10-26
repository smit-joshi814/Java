package pr8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practical8
 */
@WebServlet("/Practical8")
public class Practical8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Practical8() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String name=request.getParameter("name");
			RequestDispatcher rd;
			if(name.equals("smit")) {
				rd=request.getRequestDispatcher("Pr8_1");
				rd.forward(request, response);
			}else {
				rd=request.getRequestDispatcher("Pr8_2");
				rd.forward(request, response);
			}
		}
	}

}
