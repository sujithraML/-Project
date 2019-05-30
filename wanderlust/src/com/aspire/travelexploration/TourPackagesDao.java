package com.aspire.travelexploration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Blob;

public class TourPackagesDao {
	public boolean insertPackage(TourPackage tourPackage) {
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
		boolean flag=false;
//		Blob blob;
		try {
			preparedStatement=connectionObject.prepareStatement("insert into tour_packages values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'')");
			preparedStatement.setInt(1, tourPackage.getAgency_id());
			preparedStatement.setString(2, tourPackage.getAgency_name());
			preparedStatement.setString(3, tourPackage.getAssistance_Person());
			preparedStatement.setString(4, tourPackage.getPlace());
			preparedStatement.setInt(5, tourPackage.getPricing());
			preparedStatement.setInt(6, tourPackage.getDays());
			preparedStatement.setInt(7, tourPackage.getNights());
			preparedStatement.setString(8, tourPackage.getItinerary());
			preparedStatement.setString(9, tourPackage.getCountry());
			preparedStatement.setString(10, tourPackage.getPeriod_of_Package());
			preparedStatement.setString(11, tourPackage.getHoliday_type());
			preparedStatement.setString(12, tourPackage.getPackage_type());
			preparedStatement.setString(13, tourPackage.getTagline1());
			preparedStatement.setString(14, tourPackage.getTagline2());
			int temp=preparedStatement.executeUpdate();
			if(temp!=0) flag=true;
//			blob.setBytes(1, tourPackage.getImg());
//			preparedStatement.setBlob(15, blob);
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	public ArrayList<TourPackage> selectPackage() {
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		ArrayList<TourPackage> tourPackageList=new ArrayList<TourPackage>();
		TourPackage tourPackageObject=new TourPackage();
		PreparedStatement preparedStatement=null;
		try {
			//connectionObject.setAutoCommit(false);
			String query="select * from tour_packages";
			preparedStatement=connectionObject.prepareStatement(query);
			preparedStatement.executeQuery();
			ResultSet resultSet=preparedStatement.getResultSet();
			while(resultSet.next()) {
				tourPackageObject.setAgency_id(resultSet.getInt(1));
				tourPackageObject.setAgency_name(resultSet.getString(2));
				tourPackageObject.setAssistance_Person(resultSet.getString(3));
				tourPackageObject.setPlace(resultSet.getString(4));
				tourPackageObject.setPricing(resultSet.getInt(5));
				tourPackageObject.setDays(resultSet.getInt(6));
				tourPackageObject.setNights(resultSet.getInt(7));
				tourPackageObject.setItinerary(resultSet.getString(8));
				tourPackageObject.setCountry(resultSet.getString(9));
				tourPackageObject.setPeriod_of_Package(resultSet.getString(10));
				tourPackageObject.setHoliday_type(resultSet.getString(11));
				tourPackageObject.setPackage_type(resultSet.getString(12));
				tourPackageObject.setTagline1(resultSet.getString(13));
				tourPackageObject.setTagline2(resultSet.getString(14));
				Blob blob=(Blob) resultSet.getBlob(15);
				tourPackageObject.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackageList.add(tourPackageObject);
				//connectionObject.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tourPackageList;
	}
	public ArrayList<TourPackage> selectPackageByCountry(TourPackage tourObjectValue) {
		ArrayList<TourPackage> tourPackageList=new ArrayList<TourPackage>();
		TourPackage tourPackageObject=new TourPackage();
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		String query=null;
		try {
			query="select * from tour_packages where country=?";
			preparedStatementObject=connectionObject.prepareStatement(query);
			preparedStatementObject.setString(1,tourObjectValue.getCountry());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				tourPackageObject.setAgency_id(resultSetObject.getInt(1));
				tourPackageObject.setAgency_name(resultSetObject.getString(2));
				tourPackageObject.setAssistance_Person(resultSetObject.getString(3));
				tourPackageObject.setPlace(resultSetObject.getString(4));
				tourPackageObject.setPricing(resultSetObject.getInt(5));
				tourPackageObject.setDays(resultSetObject.getInt(6));
				tourPackageObject.setNights(resultSetObject.getInt(7));
				tourPackageObject.setItinerary(resultSetObject.getString(8));
				tourPackageObject.setCountry(resultSetObject.getString(9));
				tourPackageObject.setPeriod_of_Package(resultSetObject.getString(10));
				tourPackageObject.setHoliday_type(resultSetObject.getString(11));
				tourPackageObject.setPackage_type(resultSetObject.getString(12));
				tourPackageObject.setTagline1(resultSetObject.getString(13));
				tourPackageObject.setTagline2(resultSetObject.getString(14));
				Blob blob=(Blob) resultSetObject.getBlob(15);
				tourPackageObject.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackageList.add(tourPackageObject);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tourPackageList;
	}
	public ArrayList<TourPackage> selectPackageByPricing(TourPackage tourObjectValue) {
		ArrayList<TourPackage> tourPackageList=new ArrayList<TourPackage>();
		TourPackage tourPackageObject=new TourPackage();
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		String query=null;
		try {
			query="select * from tour_packages where pricing=?";
			preparedStatementObject=connectionObject.prepareStatement(query);
			preparedStatementObject.setInt(1,tourObjectValue.getPricing());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				tourPackageObject.setAgency_id(resultSetObject.getInt(1));
				tourPackageObject.setAgency_name(resultSetObject.getString(2));
				tourPackageObject.setAssistance_Person(resultSetObject.getString(3));
				tourPackageObject.setPlace(resultSetObject.getString(4));
				tourPackageObject.setPricing(resultSetObject.getInt(5));
				tourPackageObject.setDays(resultSetObject.getInt(6));
				tourPackageObject.setNights(resultSetObject.getInt(7));
				tourPackageObject.setItinerary(resultSetObject.getString(8));
				tourPackageObject.setCountry(resultSetObject.getString(9));
				tourPackageObject.setPeriod_of_Package(resultSetObject.getString(10));
				tourPackageObject.setHoliday_type(resultSetObject.getString(11));
				tourPackageObject.setPackage_type(resultSetObject.getString(12));
				tourPackageObject.setTagline1(resultSetObject.getString(13));
				tourPackageObject.setTagline2(resultSetObject.getString(14));
				Blob blob=(Blob) resultSetObject.getBlob(15);
				tourPackageObject.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackageList.add(tourPackageObject);
			}
		}catch(SQLException e) {
			
		}
		return tourPackageList;
	}
	public ArrayList<TourPackage> selectPackageByPackageType(TourPackage tourObjectValue) {
		ArrayList<TourPackage> tourPackageList=new ArrayList<TourPackage>();
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		TourPackage tourPackageObject=new TourPackage();
		PreparedStatement preparedStatementObject;
		String query=null;
		try {
			query="select * from tour_packages where package_type=?";
			preparedStatementObject=connectionObject.prepareStatement(query);
			preparedStatementObject.setString(1,tourObjectValue.getPackage_type());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				tourPackageObject.setAgency_id(resultSetObject.getInt(1));
				tourPackageObject.setAgency_name(resultSetObject.getString(2));
				tourPackageObject.setAssistance_Person(resultSetObject.getString(3));
				tourPackageObject.setPlace(resultSetObject.getString(4));
				tourPackageObject.setPricing(resultSetObject.getInt(5));
				tourPackageObject.setDays(resultSetObject.getInt(6));
				tourPackageObject.setNights(resultSetObject.getInt(7));
				tourPackageObject.setItinerary(resultSetObject.getString(8));
				tourPackageObject.setCountry(resultSetObject.getString(9));
				tourPackageObject.setPeriod_of_Package(resultSetObject.getString(10));
				tourPackageObject.setHoliday_type(resultSetObject.getString(11));
				tourPackageObject.setPackage_type(resultSetObject.getString(12));
				tourPackageObject.setTagline1(resultSetObject.getString(13));
				tourPackageObject.setTagline2(resultSetObject.getString(14));
				Blob blob=(Blob) resultSetObject.getBlob(15);
				tourPackageObject.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackageList.add(tourPackageObject);
			}
		}catch(SQLException e) {
			
		}
		return tourPackageList;
	}
}
