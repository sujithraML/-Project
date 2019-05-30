package com.aspire.travelexploration.daoimpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.aspire.travelexploration.dao.ConnectionFactoryMySql;
import com.aspire.travelexploration.dao.JdbcInterface;
import com.aspire.travelexploration.entity.User;
public class UserDAO implements JdbcInterface{
	public boolean insertUser(User user) {
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		InputStream image=null;
		boolean flag=false;
		
		PreparedStatement preparedStatement=null;
		try {
			try {
				String query="insert into user(username,name,email,phone,password,profilepic) values(?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Inserting user:");
					//preparedStatement.setInt(1,user.getUserId());
					preparedStatement.setString(1,user.getUsername());
					preparedStatement.setString(2,user.getName());
					preparedStatement.setString(3, user.getEmailId());
					preparedStatement.setLong(4, user.getPhone());
					preparedStatement.setString(5, user.getPassword());
					image=new FileInputStream(new File("C:/Users/sujithra.murali/Documents/wanderlust/WebContent/travel/t1.jpg"));
					preparedStatement.setBinaryStream(6, image);
					int m=preparedStatement.executeUpdate();
					System.out.println("Inserted "+m);
					if(m!=0) flag=true;
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} catch (FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
	        } finally {
	        	if(image!=null) 
	        		image.close();
	        	if(preparedStatement!=null) 
	        		preparedStatement.close();
	        	if(connection!=null) 
	        		connection.close();
	        }
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return flag;
	}
	public boolean userLogin(User user) throws SQLException {
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
		try {
			connection.setAutoCommit(false);
			String query="select * from user where username=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.executeQuery();
			ResultSet resultSet=preparedStatement.getResultSet();
			while(resultSet.next()) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean addDetails(Object object) {
		User user=new User();
		user=(User)object;
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		InputStream image=null;
		boolean flag=false;
		
		PreparedStatement preparedStatement=null;
		try {
			try {
				String query="insert into user(username,name,email,phone,password,profilepic) values(?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Inserting user:");
					//preparedStatement.setInt(1,user.getUserId());
					preparedStatement.setString(1,user.getUsername());
					preparedStatement.setString(2,user.getName());
					preparedStatement.setString(3, user.getEmailId());
					preparedStatement.setLong(4, user.getPhone());
					preparedStatement.setString(5, user.getPassword());
					image=new FileInputStream(new File("C:/Users/sujithra.murali/Documents/wanderlust/WebContent/travel/t1.jpg"));
					preparedStatement.setBinaryStream(6, image);
					int m=preparedStatement.executeUpdate();
					System.out.println("Inserted "+m);
					if(m!=0) flag=true;
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} catch (FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
	        } 
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Object> selectDetails(Object object) {
		return null;
	}
	public User getId(User user) {
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = connection.prepareStatement("select user_id from user where username=?");
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				user.setUserId(resultSet.getInt(1));
			}	
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return user;
	}
}
