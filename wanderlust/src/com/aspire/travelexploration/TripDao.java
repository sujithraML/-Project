package com.aspire.travelexploration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.sql.rowset.serial.SerialBlob;
//
//import com.mysql.jdbc.Blob;

public class TripDao {
	public void insertTrip(Trip tripValue) {
		Connection connnectionObject=ConnectionFactorySql.getSQLConnection();
		int temp;
//		Blob [] blob=new Blob[6];
		
		PreparedStatement preparedStatementObject=null;
		try {
			String qry="insert into trip values(?,?,?,?,?,?,?,'','','','','','',?,?)";
			preparedStatementObject = connnectionObject.prepareStatement(qry);
			System.out.println("queryInsert:");
				preparedStatementObject.setInt(1,tripValue.getTripId());
				preparedStatementObject.setInt(2,tripValue.getUserId());
				preparedStatementObject.setString(3, tripValue.getCountry());
				preparedStatementObject.setString(4, tripValue.getState());
				preparedStatementObject.setString(5, tripValue.getPlaceName());
				preparedStatementObject.setString(6, tripValue.getPlaceType());
				preparedStatementObject.setString(7, tripValue.getSpecialities());
//				blob[0].setBytes(1, tripValue.getPicture1());
//				blob[1].setBytes(1, tripValue.getPicture2());
//				blob[2].setBytes(1, tripValue.getPicture3());
//				blob[3].setBytes(1, tripValue.getPicture4());
//				blob[4].setBytes(1, tripValue.getPicture5());
//				blob[5].setBytes(1, tripValue.getPicture6());
//				preparedStatementObject.setBlob(8, blob[0]);
//				preparedStatementObject.setBlob(9, blob[1]);
//				preparedStatementObject.setBlob(10, blob[2]);
//				preparedStatementObject.setBlob(11, blob[3]);
//				preparedStatementObject.setBlob(12, blob[4]);
//				preparedStatementObject.setBlob(13, blob[5]);
				preparedStatementObject.setString(8, tripValue.getReview());
				preparedStatementObject.setInt(9, tripValue.getRating());
				
				temp=preparedStatementObject.executeUpdate();
				System.out.println("Insert "+temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Trip> selectTrip(Trip tripValue) {
		ArrayList<Trip> tripList=new ArrayList<Trip>();
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		String query=null;
		Trip tripObject=new Trip();
		boolean flag=false;
		//Byte [] blob=new Byte[6];
		try {
			query="select * from trip where country=?";
			preparedStatementObject=connectionObject.prepareStatement(query);
			preparedStatementObject.setString(1,tripValue.getCountry());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				flag=true;
				tripObject.setTripId(resultSetObject.getInt(1));
				tripObject.setUserId(resultSetObject.getInt(2));
				tripObject.setCountry(resultSetObject.getString(3));
				tripObject.setState(resultSetObject.getString(4));
				tripObject.setPlaceName(resultSetObject.getString(5));
				tripObject.setPlaceType(resultSetObject.getString(6));
				tripObject.setSpecialities(resultSetObject.getString(7));
				tripObject.setPicture1(resultSetObject.getBytes(8));
				tripObject.setPicture2(resultSetObject.getBytes(9));
				tripObject.setPicture3(resultSetObject.getBytes(10));
				tripObject.setPicture4(resultSetObject.getBytes(11));
				tripObject.setPicture5(resultSetObject.getBytes(12));
				tripObject.setPicture6(resultSetObject.getBytes(13));
				tripObject.setReview(resultSetObject.getString(14));
				tripObject.setRating(resultSetObject.getInt(15));
				tripList.add(tripObject);
			}
		}catch(SQLException e) {
			
		}
		if(flag==false) {
			System.out.println("No records");
		}
		return tripList;
	}
}
