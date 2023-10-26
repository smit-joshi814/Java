package modules;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getVar
 */
@WebServlet("/getVar")
public class getVar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getVar() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			Enumeration<String> names=request.getParameterNames();
			String var_value_map="";
			ArrayList<String> variations=new ArrayList<>();
			while(names.hasMoreElements()) {
				variations.add(names.nextElement());
			}
			//out.print(variations.size());
			
			for(String var_value:variations) {
			//	out.print(var_value+"\t");
				var_value_map+=","+var_value+":"+request.getParameter(var_value);
			}
			out.print(var_value_map);
			
			String values[]=var_value_map.split(",");
			for(String value:values) {
				String val_opt[]=value.split(":");
				for(int i=1;i<val_opt.length;i++) {
					out.print(val_opt[i]);
				}
				out.println();
			}
			
		}

	}

}
