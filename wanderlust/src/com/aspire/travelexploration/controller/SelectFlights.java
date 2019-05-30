package com.aspire.travelexploration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.travelexploration.entity.Flight;
import com.aspire.travelexploration.enums.FlightE;
import com.aspire.travelexploration.manager.FlightManager;

public class SelectFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Flight flight=new Flight();
	FlightManager flightManager=new FlightManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		flight.setFromLocation(request.getParameter("from").substring(0, 3));
		flight.setToLocation(request.getParameter("to").substring(0, 3));
		if(flight.getFromLocation().equals(flight.getToLocation())) {
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('choose different airports');</script>");
			out.println("</head><body></body></html>");
		}else {
			flight.setDepDate(Date.valueOf(request.getParameter("departure")));
			flight.setFlightClass(FlightE.valueOf(request.getParameter("class")));
			List <Object> flights=flightManager.searchFlights(flight);
			if(flights.isEmpty()) {
				PrintWriter out=response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('No Results found');</script>");
				out.println("</head><body></body></html>");
			}
			request.setAttribute("flights", flights);
			session.setAttribute("flightsid", flights);
		}
		if(session.getAttribute("userid")==null) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);
			}
		else
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userpage.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
