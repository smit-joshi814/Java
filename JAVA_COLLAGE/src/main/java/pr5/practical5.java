package pr5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class practical5
 */
@WebServlet("/practical5")
public class practical5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public practical5() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			out.print("<form action='practical5hdn' method='POST' >");
			out.print("<input type='hidden' value='"+request.getParameter("username")+"' name='user' />");
			out.print("<input type='hidden' value='"+request.getParameter("password")+"' name='pass' />");
			out.print("<input type='submit' value='click me' name='btnSubmit' />");
			out.print("</form>");
		}
	}
}
