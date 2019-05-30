package com.aspire.travelexploration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDao {
	public List<Flight> searchFlight(Flight flightValue) {
		List<Flight> flightList=new ArrayList<Flight>();
		Flight flightObject=new Flight();
		//SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY/MM/DD");
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		try {
			preparedStatementObject=connectionObject.prepareStatement("select * from Flight "
					+ "where from_location=? and to_location=?  and class=?");
			preparedStatementObject.setString(1,flightValue.getFromLocation());
			preparedStatementObject.setString(2,flightValue.getToLocation());
			//preparedStatementObject.setDate(3,Date.valueOf(dateFormat.parse(flightValue.getDepDate().toString()).toString()));
			preparedStatementObject.setString(3,flightValue.getFlightClass().toString());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				flightObject.setFlightId(resultSetObject.getInt(1));
				flightObject.setAirlineId(resultSetObject.getInt(2));
				flightObject.setAirLineName(resultSetObject.getString(3));
				//flightObject.setAirlineLogo(resultSetObject.getBytes(4));
				flightObject.setFromLocation(resultSetObject.getString(5));
				flightObject.setToLocation(resultSetObject.getString(6));
				flightObject.setDepartureTime(resultSetObject.getString(7));
				flightObject.setArrivalTime(resultSetObject.getString(8));
				flightObject.setDuration(resultSetObject.getString(9));
				flightObject.setTotalSeats(resultSetObject.getInt(10));
				flightObject.setBaggageAllowance(resultSetObject.getString(11));
				flightObject.setTaxes(resultSetObject.getFloat(12));
				flightObject.setFlightClass(FlightE.valueOf(resultSetObject.getString(13)));
				flightObject.setStoppages(resultSetObject.getInt(14));
				flightObject.setDepDate(resultSetObject.getDate(15));
				flightObject.setPrice(resultSetObject.getInt(16));
				flightObject.setAvailableSeats(resultSetObject.getInt(17));
				flightList.add(flightObject);
			}
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return flightList;
	}
	public ArrayList<Flight> filterByPrice(Flight flightValue) {
		ArrayList<Flight> flightList=new ArrayList<Flight>();
		Flight flightObject=new Flight();
		//SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY/MM/DD");
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		try {
			preparedStatementObject=connectionObject.prepareStatement("select * from Flight where "
					+ "from_location=? and to_location=? and class=? and price=?");
			preparedStatementObject.setString(1,flightValue.getFromLocation());
			preparedStatementObject.setString(2,flightValue.getToLocation());
			//preparedStatementObject.setDate(3,Date.valueOf(dateFormat.parse(flightValue.getDepDate().toString()).toString()));
			preparedStatementObject.setString(3,flightValue.getFlightClass().toString());
			preparedStatementObject.setInt(4, flightValue.getPrice());			
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				flightObject.setFlightId(resultSetObject.getInt(1));
				flightObject.setAirlineId(resultSetObject.getInt(2));
				flightObject.setAirLineName(resultSetObject.getString(3));
				//flightObject.setAirlineLogo(resultSetObject.getBytes(4));
				flightObject.setFromLocation(resultSetObject.getString(5));
				flightObject.setToLocation(resultSetObject.getString(6));
				flightObject.setDepartureTime(resultSetObject.getString(7));
				flightObject.setArrivalTime(resultSetObject.getString(8));
				flightObject.setDuration(resultSetObject.getString(9));
				flightObject.setTotalSeats(resultSetObject.getInt(10));
				flightObject.setBaggageAllowance(resultSetObject.getString(11));
				flightObject.setTaxes(resultSetObject.getFloat(12));
				flightObject.setFlightClass(FlightE.valueOf(resultSetObject.getString(13)));
				flightObject.setStoppages(resultSetObject.getInt(14));
				flightObject.setDepDate(resultSetObject.getDate(15));
				flightObject.setPrice(resultSetObject.getInt(16));
				flightObject.setAvailableSeats(resultSetObject.getInt(17));
				flightList.add(flightObject);
			}
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return flightList;
	}
	public boolean insertFlight(Flight flightValue) {
		boolean flag=false;
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
//		Blob blob;
		try {
			preparedStatement=connectionObject.prepareStatement("insert into flight values"
					+ "(?,?,?,'',?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, flightValue.getAirlineId());
			preparedStatement.setInt(2, flightValue.getFlightId());
			preparedStatement.setString(3, flightValue.getAirLineName());
			preparedStatement.setString(4, flightValue.getFromLocation());
			preparedStatement.setString(5, flightValue.getToLocation());
			preparedStatement.setString(6, flightValue.getDepartureTime());
			preparedStatement.setString(7, flightValue.getArrivalTime());
			preparedStatement.setString(8, flightValue.getDuration());
			preparedStatement.setInt(9, flightValue.getTotalSeats());
			preparedStatement.setString(10, flightValue.getBaggageAllowance());
			preparedStatement.setFloat(11, flightValue.getTaxes());
			preparedStatement.setString(12, flightValue.getFlightClass().toString());
			preparedStatement.setInt(13, flightValue.getStoppages());
			preparedStatement.setDate(14, (Date) flightValue.getDepDate());
			preparedStatement.setInt(15, flightValue.getPrice());
			preparedStatement.setInt(16, flightValue.getAvailableSeats());
			int temp=preparedStatement.executeUpdate();
			if(temp!=0) flag=true;
//			blob.setBytes(1, tourPackage.getImg());
//			preparedStatement.setBlob(4, blob);
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
}
