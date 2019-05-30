package intranet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Contact abObjCheck=new Contact();
	Contact abObj=new Contact();
	QuerySql<Contact> qry=new QuerySql<Contact>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		abObj.setEmailId( request.getParameter("username"));
		abObj.setPassword(request.getParameter("password"));

		try {
			abObjCheck=qry.queryLogin(abObj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(abObj.getEmailId()!=null && abObj.getPassword()!=null)
			response.sendRedirect("homepage.html");
		else
			response.sendRedirect("loginp.html");
	}

}
