package intranet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveContact
 */
public class RemoveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonalContact pcObj=new PersonalContact();
	QuerySql<Contact> qry=new QuerySql<Contact>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		pcObj.setNumber(Long.parseLong(request.getParameter("number")));
		qry.removeContact(pcObj);
		PrintWriter out=response.getWriter();
		out.println("Contact has been Discontinued");
		if(pcObj.getNumber()==0) 
			response.sendRedirect("remove.html");
	}

}
