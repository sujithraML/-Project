package com.aspire.travelexploration.manager;

import java.util.List;

import com.aspire.travelexploration.daoimpl.TripDAO;
import com.aspire.travelexploration.entity.Trip;

public class TripManager {
	TripDAO tripDao=new TripDAO();
	public boolean addTrip(Trip trip) {
		return tripDao.addDetails(trip);
	}
	public List<Object> selectTripByCountry(Trip trip){
		return tripDao.selectDetails(trip);
	}
}
