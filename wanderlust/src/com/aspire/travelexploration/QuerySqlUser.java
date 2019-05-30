package com.aspire.travelexploration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuerySqlUser{
	
//	public ArrayList<T> querySelect(ArrayList <T> phoneBook) {
//		ArrayList <T> oldPhoneBook=new ArrayList<T>();
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		try {
//			ps = con.prepareStatement("select * from user");
//			ps.executeQuery();
//			ResultSet rs=ps.getResultSet();
//			System.out.println("In Sql server : ");
//			while(rs.next()) {
//				String emailIdValue=rs.getString(1);
//				String passwordValue=rs.getString(2);
//				User userObj=new User();
//				userObj.setEmailId(emailIdValue);
//				userObj.setPassword(passwordValue);		
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return oldPhoneBook;
//	}
//	public void deleteContact(PersonalContact pcObjValue) {
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		try {
//			ps=con.prepareStatement("delete from contact where contactid=?");
//			ps.setInt(1, pcObjValue.getContactid());
//			ps.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public PersonalContact updateContact(int contactIdValue) {
//		PersonalContact pcObj=new PersonalContact();
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		try {
//			ps=con.prepareStatement("select * from contact where contactid=?");
//			ps.setInt(1, contactIdValue);
//			ps.executeQuery();
//			ResultSet rs=ps.getResultSet();
//			while(rs.next()){	
//				pcObj.setName(rs.getString(2));
//				pcObj.setContactid(rs.getInt(1));
//				pcObj.setEmail(rs.getString(3));
//				pcObj.setCity(rs.getString(4));
//				pcObj.setCompanyname(rs.getString(5));
//				pcObj.setType(type.valueOf(rs.getString(6)));
//				pcObj.setStatusOfContact(status.valueOf(rs.getString(7)));
//				pcObj.setNumber(rs.getLong(8));	
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return pcObj;
//	}
//	public void removeContact(PersonalContact pcObj) {
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		try {
//			ps=con.prepareStatement("update contact set status ='DISCONTINUED' where number=?");
//			ps.setLong(1, pcObj.getNumber());
//			ps.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public PersonalContact[] selectByName(String nameValue) {
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		PersonalContact []pcObj=new PersonalContact[10];
//		try {
//			ps=con.prepareStatement("select * from contact where name=?");
//			ps.setString(1, nameValue);
//			ps.executeQuery();
//			ResultSet rs=ps.getResultSet();
//			int i=0;
//			while(rs.next()){	
//				pcObj[i]=new PersonalContact();
//				pcObj[i].setName(rs.getString(2));
//				pcObj[i].setContactid(rs.getInt(1));
//				pcObj[i].setEmail(rs.getString(3));
//				pcObj[i].setCity(rs.getString(4));
//				pcObj[i].setCompanyname(rs.getString(5));
//				pcObj[i].setType(type.valueOf(rs.getString(6)));
//				pcObj[i].setStatusOfContact(status.valueOf(rs.getString(7)));
//				pcObj[i].setNumber(rs.getLong(8));	
//				i++;
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return pcObj;
//	}
//	public PersonalContact selectByNumber(long numberValue) {
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		PersonalContact pcObj=new PersonalContact();
//		try {
//			ps=con.prepareStatement("select * from contact where number=?");
//			ps.setLong(1, numberValue);
//			ps.executeQuery();
//			ResultSet rs=ps.getResultSet();
//			while(rs.next()){	
//				pcObj.setName(rs.getString(2));
//				pcObj.setContactid(rs.getInt(1));
//				pcObj.setEmail(rs.getString(3));
//				pcObj.setCity(rs.getString(4));
//				pcObj.setCompanyname(rs.getString(5));
//				pcObj.setType(type.valueOf(rs.getString(6)));
//				pcObj.setStatusOfContact(status.valueOf(rs.getString(7)));
//				pcObj.setNumber(rs.getLong(8));	
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return pcObj;
//	}
//	public PersonalContact[] selectByCompany(String companyValue) {
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		PreparedStatement ps;
//		PersonalContact [] pcObj=new PersonalContact[10];
//
//		try {
//			ps=con.prepareStatement("select * from contact where companyname=?");
//			ps.setString(1, companyValue);
//			ps.executeQuery();
//			ResultSet rs=ps.getResultSet();
//			int i=0;
//			while(rs.next()){	
//				pcObj[i]=new PersonalContact();
//				pcObj[i].setName(rs.getString(2));
//				pcObj[i].setContactid(rs.getInt(1));
//				pcObj[i].setEmail(rs.getString(3));
//				pcObj[i].setCity(rs.getString(4));
//				pcObj[i].setCompanyname(rs.getString(5));
//				pcObj[i].setType(type.valueOf(rs.getString(6)));
//				pcObj[i].setStatusOfContact(status.valueOf(rs.getString(7)));
//				pcObj[i].setNumber(rs.getLong(8));	
//				i++;
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return pcObj;
//	}
//	public void addContact(PersonalContact pcObj) {
//		Connection con=ConnectionFactorySql.getSQLConnection();
//		
//		PreparedStatement ps=null;
//		try {
//			con.setAutoCommit(false);
//			String qry="insert into contact values(?,?,?,?,?,?,?,?)";
//			ps = con.prepareStatement(qry);
//			System.out.println("queryInsert:");
//				ps.setInt(1,pcObj.getContactid());
//				ps.setString(2, pcObj.getName());
//				ps.setString(3,pcObj.getEmail());
//				ps.setString(4,pcObj.getCity());
//				ps.setString(5,pcObj.getCompanyname());
//				String typee=""+pcObj.getType();
//				ps.setString(6,typee);
//				String status=""+pcObj.getStatusOfContact();
//				ps.setString(7,status);
//				ps.setLong(8,pcObj.getNumber());
//				int m=ps.executeUpdate();
//				System.out.println("Inserted : "+ m);
//				con.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public int queryInsert(User userObject) {
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		InputStream image=null;
		int m=0;
		
		PreparedStatement preparedStatement=null;
		try {
			try {
				String query="insert into user values(?,?,?,?,?,?,?)";
				preparedStatement = connectionObject.prepareStatement(query);
				System.out.println("queryInsert:");
					preparedStatement.setInt(1,userObject.getUserId());
					preparedStatement.setString(2,userObject.getUsername());
					preparedStatement.setString(3,userObject.getName());
					preparedStatement.setString(4, userObject.getEmailId());
					preparedStatement.setLong(5, userObject.getPhone());
					preparedStatement.setString(6, userObject.getPassword());
					image=new FileInputStream(new File("C:/Users/sujithra.murali/Documents/wanderlust/WebContent/travel/t1.jpg"));
					preparedStatement.setBinaryStream(7, image);
					m=preparedStatement.executeUpdate();
					System.out.println("Inserted "+m);
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} catch (FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
	        } finally {
	        	if(image!=null) 
	        		image.close();
	        	if(preparedStatement!=null) 
	        		preparedStatement.close();
	        	if(connectionObject!=null) 
	        		connectionObject.close();
	        }
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return m;
	}
	public boolean queryLogin(User userObject) throws SQLException {
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatement=null;
		try {
			connectionObject.setAutoCommit(false);
			String query="select * from user where username=?";
			preparedStatement=connectionObject.prepareStatement(query);
			preparedStatement.setString(1, userObject.getUsername());
			preparedStatement.executeQuery();
			ResultSet rs=preparedStatement.getResultSet();
			while(rs.next()) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				connectionObject.close();
		}
		return false;
	}
}

