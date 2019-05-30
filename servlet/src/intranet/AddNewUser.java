package intranet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Contact cObj=new Contact();
	QuerySql<Contact> qry=new QuerySql<Contact>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getParameter("name");
		String password=(String) request.getParameter("password");
		String passwordduplicate=(String) request.getParameter("passwordduplicate");
		if(password.equals(passwordduplicate)) {

			cObj.setEmailId(username);
			cObj.setPassword(password);

			qry.queryInsert(cObj);
			PrintWriter out =response.getWriter();
			out.println("User Registration Successful");
		}
		if(cObj.getEmailId()==null && cObj.getPassword()==null) 
			response.sendRedirect("SignUp.html");
	}

}
