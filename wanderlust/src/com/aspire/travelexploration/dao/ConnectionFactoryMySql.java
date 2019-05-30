package com.aspire.travelexploration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.aspire.travelexploration.util.MySql;

public class ConnectionFactoryMySql implements MySql{
	private static Connection connection=null;
	
	private ConnectionFactoryMySql() {
		
	}
	public static Connection getSQLConnection() {
		//if(connection==null) {
			try {
				java.util.Properties properties=new java.util.Properties();
				
				Class.forName(MY_SQL_driverName);
				properties.put(userName, MY_SQL_username);
				properties.put(password, MY_SQL_password);
				connection=DriverManager.getConnection(MY_SQL_url,properties);
			}
			catch(SQLException sqlException) {
				System.out.println("SQLException : "+sqlException.getMessage());
			}
			catch(Exception exception){
				System.out.println("Exception : "+exception.getMessage());
			}
		//}
			return connection;
	}	
}
	
