package com.aspire.travelexploration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.travelexploration.entity.Ticket;
import com.aspire.travelexploration.manager.TicketManager;

public class ViewTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketManager ticketManager=new TicketManager();
	Ticket ticket=new Ticket();
	List<Object> tickets=new ArrayList<Object>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("userid")!=null){
		ticket.setUserId(Integer.parseInt(session.getAttribute("userid").toString()));
		tickets=ticketManager.searchTicket(ticket);
		if(tickets==null) {
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('You have not booked any tickets');</script>");
			out.println("</head><body></body></html>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userpage.jsp");
			requestDispatcher.include(request, response);		
			}else {
			request.setAttribute("tickets", tickets);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Tickets.jsp");
			requestDispatcher.include(request, response);
			}
		}
		else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);
		}
	}
}
