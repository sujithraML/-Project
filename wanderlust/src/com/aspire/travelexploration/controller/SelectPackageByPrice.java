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
import com.aspire.travelexploration.entity.TourPackage;
import com.aspire.travelexploration.manager.TourPackageManager;

public class SelectPackageByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourPackageManager tourPackageManager=new TourPackageManager();
	TourPackage tourPackage=new TourPackage();
	List<TourPackage> tourPackages=new ArrayList<TourPackage>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tourPackage.setPricing(Integer.parseInt(request.getParameter("price").substring(10, 14)));
		tourPackageManager.selectPackagesByPricing(tourPackage);
		PrintWriter out =response.getWriter();
		if(tourPackages.isEmpty()) {
			out.println("<script type='text/javascript'>");
			out.println("alert('No Packages found');</script>");
			out.println("</head><body></body></html>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("tourpackages.jsp");
			requestDispatcher.include(request, response);
		}
		else {
			request.setAttribute("filteredByPrice", tourPackages);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("tourpackages.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
