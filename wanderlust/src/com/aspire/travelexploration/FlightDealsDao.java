package com.aspire.travelexploration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FlightDealsDao {
	public ArrayList<FlightDeals> selectFlightDeals() {
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		ArrayList<FlightDeals> flightDeals=new ArrayList<FlightDeals>();
		PreparedStatement preparedStatement=null;
		FlightDeals flightDealsObject=new FlightDeals();
		try {
			//connectionObject.setAutoCommit(false);
			String query="select * from flight_deals";
			preparedStatement=connectionObject.prepareStatement(query);
			preparedStatement.executeQuery();
			ResultSet resultSet=preparedStatement.getResultSet();
			while(resultSet.next()) {
				flightDealsObject.setCouponCode((resultSet.getString(1)));
				flightDealsObject.setOfferDetails(resultSet.getString(2));
				flightDealsObject.setMinimumBookingAmount(resultSet.getInt(3));
				flightDealsObject.setBookingChannel(resultSet.getString(4));
				flightDealsObject.setApplicableBanks(resultSet.getString(5));
				flightDealsObject.setValidity((resultSet.getString(6)));
				flightDealsObject.setTagLine((resultSet.getString(7)));
				flightDeals.add(flightDealsObject);
				//connectionObject.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flightDeals;
	}
}
