package com.aspire.travelexploration.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.dao.ConnectionFactoryMySql;
import com.aspire.travelexploration.dao.JdbcInterface;
import com.aspire.travelexploration.entity.TourPackage;
import com.mysql.jdbc.Blob;

public class TourPackagesDAO implements JdbcInterface{

	public ArrayList<TourPackage> selectPackageByCountry(TourPackage tourObjectValue) {
		ArrayList<TourPackage> tourPackageList=new ArrayList<TourPackage>();
		TourPackage tourPackage=new TourPackage();
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		String query=null;
		try {
			query="select * from tour_packages where country=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,tourObjectValue.getCountry());
			ResultSet resultSetObject=preparedStatement.executeQuery();
			while(resultSetObject.next()) {
				tourPackage.setPackage_id(resultSetObject.getInt(1));
				tourPackage.setAgency_name(resultSetObject.getString(2));
				tourPackage.setAssistance_Person(resultSetObject.getString(3));
				tourPackage.setPlace(resultSetObject.getString(4));
				tourPackage.setPricing(resultSetObject.getInt(5));
				tourPackage.setDays(resultSetObject.getInt(6));
				tourPackage.setNights(resultSetObject.getInt(7));
				tourPackage.setItinerary(resultSetObject.getString(8));
				tourPackage.setCountry(resultSetObject.getString(9));
				tourPackage.setPeriod_of_Package(resultSetObject.getString(10));
				tourPackage.setHoliday_type(resultSetObject.getString(11));
				tourPackage.setPackage_type(resultSetObject.getString(12));
				tourPackage.setTagline1(resultSetObject.getString(13));
				tourPackage.setTagline2(resultSetObject.getString(14));
				//Blob blob=(Blob) resultSetObject.getBlob(15);
				//tourPackage.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackageList.add(tourPackage);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tourPackageList;
	}
	public ArrayList<TourPackage> selectPackageByPricing(TourPackage tourObjectValue) {
		ArrayList<TourPackage> tourPackages=new ArrayList<TourPackage>();
		TourPackage tourPackage=new TourPackage();
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		String query=null;
		try {
			query="select * from tour_packages where pricing=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,tourObjectValue.getPricing());
			ResultSet resultSetObject=preparedStatement.executeQuery();
			while(resultSetObject.next()) {
				tourPackage.setPackage_id(resultSetObject.getInt(1));
				tourPackage.setAgency_name(resultSetObject.getString(2));
				tourPackage.setAssistance_Person(resultSetObject.getString(3));
				tourPackage.setPlace(resultSetObject.getString(4));
				tourPackage.setPricing(resultSetObject.getInt(5));
				tourPackage.setDays(resultSetObject.getInt(6));
				tourPackage.setNights(resultSetObject.getInt(7));
				tourPackage.setItinerary(resultSetObject.getString(8));
				tourPackage.setCountry(resultSetObject.getString(9));
				tourPackage.setPeriod_of_Package(resultSetObject.getString(10));
				tourPackage.setHoliday_type(resultSetObject.getString(11));
				tourPackage.setPackage_type(resultSetObject.getString(12));
				tourPackage.setTagline1(resultSetObject.getString(13));
				tourPackage.setTagline2(resultSetObject.getString(14));
				//Blob blob=(Blob) resultSetObject.getBlob(15);
				//tourPackage.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackages.add(tourPackage);
			}
		}catch(SQLException e) {
			
		}
		return tourPackages;
	}
	public ArrayList<TourPackage> selectPackageByPackageType(TourPackage tourObjectValue) {
		ArrayList<TourPackage> tourPackages=new ArrayList<TourPackage>();
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		TourPackage tourPackage=new TourPackage();
		PreparedStatement preparedStatement;
		String query=null;
		try {
			query="select * from tour_packages where package_type=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,tourObjectValue.getPackage_type());
			ResultSet resultSetObject=preparedStatement.executeQuery();
			while(resultSetObject.next()) {
				tourPackage.setPackage_id(resultSetObject.getInt(1));
				tourPackage.setAgency_name(resultSetObject.getString(2));
				tourPackage.setAssistance_Person(resultSetObject.getString(3));
				tourPackage.setPlace(resultSetObject.getString(4));
				tourPackage.setPricing(resultSetObject.getInt(5));
				tourPackage.setDays(resultSetObject.getInt(6));
				tourPackage.setNights(resultSetObject.getInt(7));
				tourPackage.setItinerary(resultSetObject.getString(8));
				tourPackage.setCountry(resultSetObject.getString(9));
				tourPackage.setPeriod_of_Package(resultSetObject.getString(10));
				tourPackage.setHoliday_type(resultSetObject.getString(11));
				tourPackage.setPackage_type(resultSetObject.getString(12));
				tourPackage.setTagline1(resultSetObject.getString(13));
				tourPackage.setTagline2(resultSetObject.getString(14));
				//Blob blob=(Blob) resultSetObject.getBlob(15);
				//tourPackage.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackages.add(tourPackage);
			}
		}catch(SQLException e) {
			
		}
		return tourPackages;
	}
	@Override
	public boolean addDetails(Object object) {
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
		TourPackage tourPackage=(TourPackage)object;
		boolean flag=false;
//			Blob blob;
		try {
			preparedStatement=connection.prepareStatement("insert into tour_packages values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'')");
			preparedStatement.setInt(1, tourPackage.getPackage_id());
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
//				blob.setBytes(1, tourPackage.getImg());
//				preparedStatement.setBlob(15, blob);
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Object> selectDetails(Object object) {
		Connection connectionObject=ConnectionFactoryMySql.getSQLConnection();
		List<Object> tourPackages=new ArrayList<Object>();
		TourPackage tourPackage=new TourPackage();
		PreparedStatement preparedStatement=null;
		try {
			//connectionObject.setAutoCommit(false);
			String query="select * from tour_packages";
			preparedStatement=connectionObject.prepareStatement(query);
			preparedStatement.executeQuery();
			ResultSet resultSet=preparedStatement.getResultSet();
			while(resultSet.next()) {
				tourPackage.setPackage_id(resultSet.getInt(1));
				tourPackage.setAgency_name(resultSet.getString(2));
				tourPackage.setAssistance_Person(resultSet.getString(3));
				tourPackage.setPlace(resultSet.getString(4));
				tourPackage.setPricing(resultSet.getInt(5));
				tourPackage.setDays(resultSet.getInt(6));
				tourPackage.setNights(resultSet.getInt(7));
				tourPackage.setItinerary(resultSet.getString(8));
				tourPackage.setCountry(resultSet.getString(9));
				tourPackage.setPeriod_of_Package(resultSet.getString(10));
				tourPackage.setHoliday_type(resultSet.getString(11));
				tourPackage.setPackage_type(resultSet.getString(12));
				tourPackage.setTagline1(resultSet.getString(13));
				tourPackage.setTagline2(resultSet.getString(14));
				//Blob blob=(Blob) resultSet.getBlob(15);
				//tourPackage.setImg(blob.getBytes(1, (int)blob.length()));	
				tourPackages.add(tourPackage);
				//connectionObject.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tourPackages;
	}
}
