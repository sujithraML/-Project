package com.aspire.travelexploration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aspire.travelexploration.entity.TourPackage;
import com.aspire.travelexploration.manager.TourPackageManager;

public class SelectPackages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourPackageManager tourPackageManager=new TourPackageManager();
	TourPackage dummyObject=new TourPackage();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tour_packages", tourPackageManager.selectPackage(dummyObject));
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/tourpackages.jsp");
		requestDispatcher.include(request, response);
	}

}
