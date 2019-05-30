package com.aspire.travelexploration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.travelexploration.entity.User;
import com.aspire.travelexploration.manager.UserManager;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManager userManager=new UserManager();
	User user=new User();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		HttpSession session=request.getSession();
			if(userManager.isUserPresent(user)) {
				session.setAttribute("userid", userManager.selectUser(user));
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("userpage.jsp");
				requestDispatcher.include(request, response);
			}
			else {
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
				requestDispatcher.include(request, response);
			}
	}

}
