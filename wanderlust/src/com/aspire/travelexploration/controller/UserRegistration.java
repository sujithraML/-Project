package com.aspire.travelexploration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.travelexploration.entity.User;
import com.aspire.travelexploration.manager.UserManager;

public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user=new User();
	UserManager userManager=new UserManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		user.setName((String) request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setUsername((String) request.getParameter("username"));
		user.setEmailId((String) request.getParameter("email"));
		if(userManager.register(user)) {
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('registration successful! Login again to enter');</script>");
			out.println("</head><body></body></html>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);
		}
		else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
