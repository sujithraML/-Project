package intranet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuerySql <Contact>qry=new QuerySql<Contact>();
	PersonalContact pcObj=new PersonalContact();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		pcObj.setContactid(Integer.parseInt(request.getParameter("id")));
		pcObj.setName(request.getParameter("name"));
		pcObj.setNumber(Long.parseLong(request.getParameter("number")));
		pcObj.setEmail(request.getParameter("email"));
		pcObj.setCity(request.getParameter("city"));
		pcObj.setCompanyname(request.getParameter("company"));
		pcObj.setType(type.valueOf(request.getParameter("type")));
		pcObj.setStatusOfContact(status.valueOf(request.getParameter("status")));
		qry.addContact(pcObj);
		PrintWriter out=response.getWriter();
		out.println("Contact Updated Successfully");
	}

}
