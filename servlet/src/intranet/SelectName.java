package intranet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuerySql<Contact> qry=new QuerySql<Contact>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PersonalContact [] pcObj=qry.selectByName(request.getParameter("name"));
		PrintWriter out=response.getWriter();
		int i=0;
		while(pcObj[i].contactid!=0) {
		out.println(pcObj[i].contactid+"\t"+pcObj[i].name+"\t"+pcObj[i].number+"\t"+pcObj[i].email+"\t"+pcObj[i].companyname+"\t"+pcObj[i].city+"\t"+pcObj[i].type+"\t"+pcObj[i].statusOfContact);
		i++;
		}
		if(pcObj[0].getName()==null)
			response.sendRedirect("findbyname.html");
	}

}