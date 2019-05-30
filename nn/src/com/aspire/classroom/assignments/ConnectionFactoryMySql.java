package com.aspire.classroom.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryMySql {
	public static Connection getMYSQLConnection() {
		Connection con=null;
		try {
			java.util.Properties p=new java.util.Properties();
			String MY_SQL_driverName="com.mysql.jdbc.Driver";
			Class.forName(MY_SQL_driverName);
			p.put("user", "root");
			p.put("password", "aspire@123");
			String url="jdbc:mysql://localhost:3306/city";
			con=DriverManager.getConnection(url,p);
		}
		catch(SQLException sqe) {
			System.out.println("SQLException : "+sqe.getMessage());
		}
		catch(Exception e2){
			System.out.println("Exception : "+e2.getMessage());
		}
		return con;
	}
}

