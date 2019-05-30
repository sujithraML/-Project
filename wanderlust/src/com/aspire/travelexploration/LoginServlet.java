package com.aspire.travelexploration;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aspire.travelexploration.entity.User;
import com.aspire.travelexploration.daoimpl.UserDAO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user=new User();
	UserDAO userControl=new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		try {
			if(userControl.userLogin(user))
				response.sendRedirect("userpage.html");
			else
				response.sendRedirect("homepage.html");
		} catch (IOException | SQLException ioException) {
			ioException.printStackTrace();
		}
		
	}

}
