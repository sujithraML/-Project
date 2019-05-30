package com.aspire.classroom.assignments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryMySql {
	public void query() {
		Connection con=ConnectionFactoryMySql.getMYSQLConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from city");
			ps.executeQuery();
			ResultSet rs=ps.getResultSet();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
