package intranet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateValues extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuerySql<Contact> qry=new QuerySql<Contact>();
	PersonalContact pcObj=new PersonalContact();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		pcObj=qry.updateContact(Integer.parseInt(request.getParameter("id")));
		qry.deleteContact(pcObj);
		PrintWriter out=response.getWriter();
		out.println(" <!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>web contacts</title>" + 
				"</head>" + 
				"<body>" + 
				"<form  method=\"post\" action=\"UpdateRest\">" +"<br>"+ 
				"Contact Id:<br><input type='text' name='id' value="+pcObj.contactid +"><br>"+
				"Contact Name:<br><input type='text' name='name' value="+pcObj.name+"><br>"+ 
				"Contact number:<br><input type='text' name='number' value="+pcObj.number+"><br>"+ 
				"Contact email:<br><input type='text' name='email' value="+pcObj.email+"><br>"+ 
				"Contact company:<br><input type='text' name='company' value="+pcObj.companyname+"><br>"+
				"Contact city:<br><input type='text' name='city' value="+pcObj.city+"><br>"+ 
				"Contact type:<br><input type='text' name='type' value="+pcObj.type+"><br>"+ 
				"Contact status:<br><input type='text' name='status' value="+pcObj.statusOfContact+"><br>"+
				"<input type='submit' value='Update'>" +"<br>"+ 
				"</form>" + 
				"</body>" + 
				"</html>");
		if(pcObj.getContactid()==0) 
			response.sendRedirect("Update.html");
		}

}
