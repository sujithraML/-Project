package com.aspire.classroom.assignments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class QuerySql<T>{
	
	public ArrayList<T> querySelect(ArrayList <T> phoneBook) {
		ArrayList <T> oldPhoneBook=new ArrayList<T>();
		Connection con=ConnectionFactorySql.getSQLConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from phonebooktable");
			ps.executeQuery();
			ResultSet rs=ps.getResultSet();
			System.out.println("In Sql server : ");
			while(rs.next()) {
				String name=rs.getString(1);
				Long number=rs.getLong(2);
				Contact cObj=new Contact();
				cObj.setContactName(name);
				cObj.setContactNumber(number);
				oldPhoneBook.add((T) cObj);
				System.out.println(name+" "+number);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oldPhoneBook;
	}
//	public void queryUpdate(ArrayList <T> phoneBook) {		
//	}
	public void queryInsert(ArrayList <T> phoneBook) {
		Connection con=ConnectionFactorySql.getSQLConnection();
		PreparedStatement ps=null;
		int noOfRows=0;
		try {
			String delqry="delete from phonebooktable";
			ps=con.prepareStatement(delqry);
			int q=ps.executeUpdate();
			String qry="insert into phonebooktable values(?,?)";
			ps = con.prepareStatement(qry);
			Iterator <Contact> itrObj=(Iterator<Contact>) phoneBook.iterator();
			while(itrObj.hasNext()) {
				Contact abObj=itrObj.next();
				ps.setString(1,abObj.getContactName());
				ps.setLong(2,abObj.getContactNumber());
				int m=ps.executeUpdate();
				noOfRows+=m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(noOfRows+" rows affected");
	}
}
