package com.aspire.classroom.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactorySql {
	public static Connection getSQLConnection() {
		Connection con=null;
		try {
			java.util.Properties p=new java.util.Properties();
			String SQL_driverName="net.sourceforge.jtds.jdbc.Driver";
			
			Class.forName(SQL_driverName);
			p.put("user", "sa");
			p.put("password", "aspire@123");
			String url="jdbc:jtds:sqlserver://localhost:1433;databaseName=Phonebook";
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
