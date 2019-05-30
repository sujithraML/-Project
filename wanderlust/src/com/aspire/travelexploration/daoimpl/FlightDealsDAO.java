package com.aspire.travelexploration.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.dao.ConnectionFactoryMySql;
import com.aspire.travelexploration.dao.JdbcInterface;
import com.aspire.travelexploration.entity.FlightDeal;

public class FlightDealsDAO implements JdbcInterface{

	@Override
	public boolean addDetails(Object object) {
		return false;
	}

	@Override
	public List<Object> selectDetails(Object object) {
		Connection connectionObject=ConnectionFactoryMySql.getSQLConnection();
		List<Object> flightDeals=new ArrayList<Object>();
		PreparedStatement preparedStatement=null;
		try {
			//connectionObject.setAutoCommit(false);
			String query="select * from flight_deals";
			preparedStatement=connectionObject.prepareStatement(query);
			preparedStatement.executeQuery();
			ResultSet resultSet=preparedStatement.getResultSet();
			while(resultSet.next()) {
				FlightDeal flightDeal=new FlightDeal();
				flightDeal.setCouponCode((resultSet.getString(1)));
				flightDeal.setOfferDetails(resultSet.getString(2));
				flightDeal.setMinimumBookingAmount(resultSet.getInt(3));
				flightDeal.setBookingChannel(resultSet.getString(4));
				flightDeal.setApplicableBanks(resultSet.getString(5));
				flightDeal.setValidity((resultSet.getString(6)));
				flightDeal.setTagLine((resultSet.getString(7)));
				flightDeals.add(flightDeals);
				//connectionObject.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flightDeals;
	}
}
