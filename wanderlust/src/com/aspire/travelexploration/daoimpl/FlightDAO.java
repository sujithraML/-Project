package com.aspire.travelexploration.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.dao.ConnectionFactoryMySql;
import com.aspire.travelexploration.dao.JdbcInterface;
import com.aspire.travelexploration.entity.Flight;
import com.aspire.travelexploration.enums.FlightE;

public class FlightDAO implements JdbcInterface{
	
	public ArrayList<Flight> filterByPrice(Flight flight) {
		ArrayList<Flight> flights=new ArrayList<Flight>();
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement("select * from Flight where "
					+ "from_location=? and to_location=? and class=? and price=?");
			connection.hashCode();
			preparedStatement.setString(1,flight.getFromLocation());
			preparedStatement.setString(2,flight.getToLocation());
			preparedStatement.setDate(3,flight.getDepDate());
			preparedStatement.setString(3,flight.getFlightClass().toString());
			preparedStatement.setInt(4, flight.getPrice());			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				flight.setFlightId(resultSet.getInt(1));
				flight.setAirlineId(resultSet.getInt(2));
				flight.setAirLineName(resultSet.getString(3));
				//flight.setAirlineLogo(resultSetObject.getBytes(4));
				flight.setFromLocation(resultSet.getString(5));
				flight.setToLocation(resultSet.getString(6));
				flight.setDepartureTime(resultSet.getString(7));
				flight.setArrivalTime(resultSet.getString(8));
				flight.setDuration(resultSet.getString(9));
				flight.setTotalSeats(resultSet.getInt(10));
				flight.setBaggageAllowance(resultSet.getString(11));
				flight.setTaxes(resultSet.getFloat(12));
				flight.setFlightClass(FlightE.valueOf(resultSet.getString(13)));
				flight.setStoppages(resultSet.getInt(14));
				flight.setDepDate(resultSet.getDate(15));
				flight.setPrice(resultSet.getInt(16));
				flight.setAvailableSeats(resultSet.getInt(17));
				flights.add(flight);
			}
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return flights;
	}
	@Override
	public boolean addDetails(Object object) {
		Flight flight=(Flight)object;
		boolean flag=false;
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
//			Blob blob;
		try {
			preparedStatement=connection.prepareStatement("insert into flight values"
					+ "(?,?,?,'',?,?,?,?,?,?,?,?,?,?,?,?,?)");
			connection.hashCode();
			preparedStatement.setInt(1, flight.getAirlineId());
			preparedStatement.setInt(2, flight.getFlightId());
			preparedStatement.setString(3, flight.getAirLineName());
			preparedStatement.setString(4, flight.getFromLocation());
			preparedStatement.setString(5, flight.getToLocation());
			preparedStatement.setString(6, flight.getDepartureTime());
			preparedStatement.setString(7, flight.getArrivalTime());
			preparedStatement.setString(8, flight.getDuration());
			preparedStatement.setInt(9, flight.getTotalSeats());
			preparedStatement.setString(10, flight.getBaggageAllowance());
			preparedStatement.setFloat(11, flight.getTaxes());
			preparedStatement.setString(12, flight.getFlightClass().toString());
			preparedStatement.setInt(13, flight.getStoppages());
			preparedStatement.setDate(14, (Date) flight.getDepDate());
			preparedStatement.setInt(15, flight.getPrice());
			preparedStatement.setInt(16, flight.getAvailableSeats());
			int temp=preparedStatement.executeUpdate();
			if(temp!=0) flag=true;
//				blob.setBytes(1, tourPackage.getImg());
//				preparedStatement.setBlob(4, blob);
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Object> selectDetails(Object object) {
		List<Object> flights=new ArrayList<Object>();
		Flight flightValue=(Flight) object;
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		connection.hashCode();
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement("select * from Flight "
					+ "where from_location=? and to_location=? and departure_date =? and class=?");		//
			preparedStatement.setString(1,flightValue.getFromLocation());
			preparedStatement.setString(2,flightValue.getToLocation());
			preparedStatement.setDate(3,flightValue.getDepDate());
			preparedStatement.setString(4,flightValue.getFlightClass().toString());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Flight flight=new Flight();
				flight.setFlightId(resultSet.getInt(1));
				flight.setAirlineId(resultSet.getInt(2));
				flight.setAirLineName(resultSet.getString(3));
				//flight.setAirlineLogo(resultSetObject.getBytes(4));
				flight.setFromLocation(resultSet.getString(5));
				flight.setToLocation(resultSet.getString(6));
				flight.setDepartureTime(resultSet.getString(7));
				flight.setArrivalTime(resultSet.getString(8));
				flight.setDuration(resultSet.getString(9));
				flight.setTotalSeats(resultSet.getInt(10));
				flight.setBaggageAllowance(resultSet.getString(11));
				flight.setTaxes(resultSet.getFloat(12));
				flight.setFlightClass(FlightE.valueOf(resultSet.getString(13)));
				flight.setStoppages(resultSet.getInt(14));
				flight.setDepDate(resultSet.getDate(15));
				flight.setPrice(resultSet.getInt(16));
				flight.setAvailableSeats(resultSet.getInt(17));
				flights.add(flight);
			}
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		//flightAsType= flights
		return flights;
	}

}
