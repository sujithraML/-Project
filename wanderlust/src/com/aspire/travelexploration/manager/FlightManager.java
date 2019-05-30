package com.aspire.travelexploration.manager;

import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.daoimpl.FlightDAO;
import com.aspire.travelexploration.entity.Flight;

public class FlightManager {
	FlightDAO flightDao=new FlightDAO();
	List<Object> flights=new ArrayList<Object>();
	
	/* attempts to insert the flight entity details through DAO class
	 * and return true if the details has been successfully inserted */	
	public boolean insertFlights(Flight flight) {
		
		return flightDao.addDetails((Object)flight);
	}
	/*attempts to search the flight entity details with the specified from and to location and given date
	 * and return the list of flights*/
	public List<Object> searchFlights(Flight flight) {
		
		flights=flightDao.selectDetails(flight);
		return flights;
	}
	
	/*takes the flights list returned by the above method and filter it by price 
	 * the resultant list contains only the flights which has price less than the maxPrice*/
	public List<Object> filterByPrice(int maxPrice){
		List<Object> filteredFlights=new ArrayList<Object>();
		filteredFlights.add((Flight) flights);
		for(Object flight: filteredFlights) {
			if(flight instanceof Flight)
				if(((Flight)flight).getPrice()>maxPrice) {
					flights.remove(flight);
				}
		}
		return flights;
	}
}
