package com.aspire.travelexploration.manager;

import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.daoimpl.FlightDealsDAO;
import com.aspire.travelexploration.entity.FlightDeal;

public class FlightDealsManager {
	FlightDealsDAO flightDealsDAO=new FlightDealsDAO();
	
	public List<Object> selectFlightDeals(){
		List<Object> flightDeals=new ArrayList<Object> ();
		return flightDealsDAO.selectDetails(flightDeals);
	}
	public boolean insertFlightDeals(FlightDeal flightDeals) {
		return flightDealsDAO.addDetails(flightDeals);
	}
}
