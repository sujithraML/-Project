package com.aspire.travelexploration.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aspire.travelexploration.entity.Flight;
import com.aspire.travelexploration.entity.Ticket;
import com.aspire.travelexploration.enums.Status;
import com.aspire.travelexploration.manager.TicketManager;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class TicketBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketManager ticketManager=new TicketManager();
	Flight flight=new Flight();
	Ticket ticket=new Ticket();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ticket.setFlightId(Integer.parseInt(request.getParameter("flightid")));
		int number=Integer.parseInt(request.getParameter("number"));
		HttpSession session=request.getSession();
		List <Object> flights=(List<Object>)session.getAttribute("flightsid");
		flight=(Flight)flights.get(number);
		ticket.setDepDate(flight.getDepDate());
		ticket.setDepTime(flight.getDepartureTime());
		ticket.setFlightClass(flight.getFlightClass());
		ticket.setStatus(Status.valueOf("CONFIRMED"));
		ticket.setUserId(Integer.parseInt((session.getAttribute("userid").toString())));
		ticket.setPassengerName(request.getParameter("passenger"));
		ticket.setTicketId(1000+(int)(Math.random()*100));
		session.setAttribute("ticketid", ticket.getTicketId());
		session.setAttribute("flightid", ticket.getFlightId());
		ticket.setDateOfBooking(Date.valueOf(LocalDate.now()));
//		try {
		if(ticketManager.insertTicket(ticket)) {
			request.setAttribute("current_ticket", ticket);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Tickets.jsp");
			requestDispatcher.include(request, response);
		}
	//	}catch(MySQLIntegrityConstraintViolationException exception) {
			
//		}
	}
}
