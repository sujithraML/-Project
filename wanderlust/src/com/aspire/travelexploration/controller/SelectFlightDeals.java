package com.aspire.travelexploration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.aspire.travelexploration.entity.FlightDeal;
import com.aspire.travelexploration.manager.FlightDealsManager;

public class SelectFlightDeals extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDealsManager flightDealsManager=new FlightDealsManager();
	List<Object> flightDeals=new ArrayList<Object>();
	FlightDeal flightDeal=new FlightDeal();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		flightDeals=flightDealsManager.selectFlightDeals();
		Iterator<Object> iterator=flightDeals.iterator();
		PrintWriter out=response.getWriter();
		while(iterator.hasNext()) {
			flightDeal=(FlightDeal) iterator.next();
			out.println(flightDeal.getApplicableBanks()+flightDeal.getBookingChannel());
		}

	}
}
