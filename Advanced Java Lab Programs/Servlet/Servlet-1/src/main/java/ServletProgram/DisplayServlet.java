package ServletProgram;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/user")
public class DisplayServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	 String uname=req.getParameter("uname");
	 String email=req.getParameter("email");
	 long phoneno=Long.parseLong(req.getParameter("phone"));
	 
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 pw.println("*****User Details*****<br>");
	 pw.println("Username: "+uname+"<br>");
	 pw.println("Email: "+email+"<br>");
	 pw.println("Phone no: "+phoneno+"<br>");
	 
	}
	
	public String getServletinfo() {
		return "servlet displaying user details";
	}
	
	public ServletConfig getServletConfig1() {
		return this.getServletConfig();
	}

}
