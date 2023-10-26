package pr6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practical6
 */
@WebServlet("/Practical6")
public class Practical6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Practical6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			String username=request.getParameter("username");
			String Password=request.getParameter("password");
			String userInfo=username+":"+Password;
			Cookie user=new Cookie("user", userInfo);
			response.addCookie(user);
			response.setContentType("text/html");
			out.println("Cookie Saved Successfully..<br/>");
			out.print("<a href='Practical6Cookie'>See Cookie Information</a>'");
		}
	}

}
