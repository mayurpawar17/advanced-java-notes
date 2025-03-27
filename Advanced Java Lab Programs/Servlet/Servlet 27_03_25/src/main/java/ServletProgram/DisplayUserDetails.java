package ServletProgram;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/user")

public class DisplayUserDetails implements Servlet {
	

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
	
	 int uid= Integer.parseInt(req.getParameter("uid"));
	 String ufirstName=req.getParameter("ufirstName");
	 String ulastName=req.getParameter("ulastName");
	 String uemail=req.getParameter("uemail");
	 long uphone=Long.parseLong(req.getParameter("uphone"));
	 
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 pw.println("*****User Details*****<br>");
	 pw.println("User id: "+uid+"<br>");
	 pw.println("User FirstName: "+ufirstName+"<br>");
	 pw.println("User LastName: "+ulastName+"<br>");
	 pw.println("Email: "+uemail+"<br>");
	 pw.println("Phone no: "+uphone+"<br>");
	 
	}
	
	public String getServletinfo() {
		return "servlet displaying user details";
	}
	
	public ServletConfig getServletConfig1() {
		return this.getServletConfig();
	}

}
