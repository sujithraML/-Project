package intranet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonalContact pcObj=new PersonalContact();
	QuerySql <Contact> qryObj=new QuerySql<Contact>();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		pcObj.setContactid(Integer.parseInt(request.getParameter("id")));
		pcObj.setName(request.getParameter("name"));
		pcObj.setNumber(Long.parseLong(request.getParameter("number")));
		pcObj.setEmail(request.getParameter("email"));
		pcObj.setCity(request.getParameter("city"));
		pcObj.setCompanyname(request.getParameter("Company"));
		pcObj.setType(type.valueOf(request.getParameter("Relationship")));
		pcObj.setStatusOfContact(status.valueOf(request.getParameter("Status")));

		qryObj.addContact(pcObj);
		PrintWriter out = response.getWriter();
		out.println("Contact Added Successfully");
		if(pcObj.getContactid()==0 && pcObj.getName()==null && pcObj.getEmail()==null&& pcObj.getCity()==null&& pcObj.getCompanyname()==null&& pcObj.getNumber()==0&& pcObj.getStatusOfContact()==null&& pcObj.getType()==null)
			response.sendRedirect("add.html");
	}

}
