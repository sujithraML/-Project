package com.aspire.travelexploration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User userObj=new User();
	QuerySqlUser qry=new QuerySqlUser();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		int rows=0;
		String password=(String) request.getParameter("password");
		String passwordduplicate=(String) request.getParameter("passwordduplicate");
		if(password.equals(passwordduplicate)) {

			userObj.setName((String) request.getParameter("name"));
			userObj.setPassword(password);
			userObj.setUsername((String) request.getParameter("username"));
			userObj.setEmailId((String) request.getParameter("email"));

			try {
				rows=qry.queryInsert(userObj);
				PrintWriter out =response.getWriter();
				out.println("User Registration Successful");
				if(userObj.getEmailId()==null && userObj.getPassword()==null) 
					response.sendRedirect("signup.html");
				else if(rows!=0)
					response.sendRedirect("welcomepage.html");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			
		}
		else
		{
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("Passwords doesnot match");
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}

}
