package com.aspire.travelexploration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.travelexploration.entity.Ticket;
import com.aspire.travelexploration.manager.TicketManager;

public class TicketCancellation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketManager ticketManager=new TicketManager();
	Ticket ticket=new Ticket();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ticket.setTicketId(Integer.parseInt(request.getAttribute("cancel_ticket").toString()));
		HttpSession session=request.getSession();
		ticket.setTicketId(Integer.parseInt(session.getAttribute("ticketid").toString()));
		ticket.setFlightId(Integer.parseInt(session.getAttribute("flightid").toString()));
		PrintWriter out =response.getWriter();
		if(ticketManager.cancelTicket(ticket)) {
			out.println("<script type='text/javascript'>");
			out.println("alert(' Your Ticket got Cancelled Successfully');</script>");
			out.println("</head><body></body></html>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userpage.jsp");
			requestDispatcher.include(request, response);
		}
		else {
			response.sendError(404);
		}
	}
}
