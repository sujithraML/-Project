package com.aspire.travelexploration.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.dao.ConnectionFactoryMySql;
import com.aspire.travelexploration.dao.JdbcInterface;
import com.aspire.travelexploration.entity.Trip;
//import com.mysql.jdbc.Blob;

public class TripDAO implements JdbcInterface{
	@Override
	public boolean addDetails(Object object) {
		Connection connnection=ConnectionFactoryMySql.getSQLConnection();
		Trip trip=(Trip)object;
		int temp;
		boolean flag=false;
//			Blob [] blob=new Blob[6];
		
		PreparedStatement preparedStatement=null;
		try {
			String qry="insert into trip values(?,?,?,?,?,?,?,'','','','','','',?,?)";
			preparedStatement = connnection.prepareStatement(qry);
			System.out.println("queryInsert:");
				preparedStatement.setInt(1,trip.getTripId());
				preparedStatement.setInt(2,trip.getUserId());
				preparedStatement.setString(3, trip.getCountry());
				preparedStatement.setString(4, trip.getState());
				preparedStatement.setString(5, trip.getPlaceName());
				preparedStatement.setString(6, trip.getPlaceType());
				preparedStatement.setString(7, trip.getSpecialities());
//					blob[0].setBytes(1, trip.getPicture1());
//					blob[1].setBytes(1, trip.getPicture2());
//					blob[2].setBytes(1, trip.getPicture3());
//					blob[3].setBytes(1, trip.getPicture4());
//					blob[4].setBytes(1, trip.getPicture5());
//					blob[5].setBytes(1, trip.getPicture6());
//					preparedStatementObject.setBlob(8, blob[0]);
//					preparedStatementObject.setBlob(9, blob[1]);
//					preparedStatementObject.setBlob(10, blob[2]);
//					preparedStatementObject.setBlob(11, blob[3]);
//					preparedStatementObject.setBlob(12, blob[4]);
//					preparedStatementObject.setBlob(13, blob[5]);
				preparedStatement.setString(8, trip.getReview());
				preparedStatement.setInt(9, trip.getRating());
				
				temp=preparedStatement.executeUpdate();
				System.out.println("Insert "+temp);
				if(temp>0) flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Object> selectDetails(Object object) {
		List<Object> trips=new ArrayList<Object>();
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		String query=null;
		Trip tripValue=(Trip)object;
		boolean flag=false;
		//Byte [] blob=new Byte[6];
		try {
			query="select * from trip where country=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,tripValue.getCountry());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				flag=true;
				Trip trip=new Trip();
				trip.setTripId(resultSet.getInt(1));
				trip.setUserId(resultSet.getInt(2));
				trip.setCountry(resultSet.getString(3));
				trip.setState(resultSet.getString(4));
				trip.setPlaceName(resultSet.getString(5));
				trip.setPlaceType(resultSet.getString(6));
				trip.setSpecialities(resultSet.getString(7));
				trip.setPicture1(resultSet.getBytes(8));
				trip.setPicture2(resultSet.getBytes(9));
				trip.setPicture3(resultSet.getBytes(10));
				trip.setPicture4(resultSet.getBytes(11));
				trip.setPicture5(resultSet.getBytes(12));
				trip.setPicture6(resultSet.getBytes(13));
				trip.setReview(resultSet.getString(14));
				trip.setRating(resultSet.getInt(15));
				trips.add(trip);
			}
		}catch(SQLException e) {
			
		}
		if(flag==false) {
			System.out.println("No records");
		}
		return trips;
	}
}
