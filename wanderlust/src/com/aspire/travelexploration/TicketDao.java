package com.aspire.travelexploration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TicketDao {
	public boolean insertTicket(Ticket ticketValue) {
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		Flight flightObject=new Flight();
		int temp1;
		boolean flag=false;
		
		PreparedStatement preparedStatementObject=null;
		try {
			String qry="insert into ticket values(?,?,?,?,?,?,?,?,?)";
			preparedStatementObject = connectionObject.prepareStatement(qry);
			System.out.println("queryInsert:");
				preparedStatementObject.setInt(1,ticketValue.getTicketId());
				preparedStatementObject.setInt(2,ticketValue.getUserId());
				preparedStatementObject.setString(3,ticketValue.getPassengerName());
				preparedStatementObject.setInt(4, ticketValue.getFlightId());
				preparedStatementObject.setDate(5, (Date) ticketValue.getDepDate());
				preparedStatementObject.setString(6, ticketValue.getDepTime());
				preparedStatementObject.setString(7, ticketValue.getStatus().toString());
				preparedStatementObject.setDate(8, (Date) ticketValue.getDateOfBooking());
				preparedStatementObject.setString(9, ticketValue.getFlightClass().toString());
				temp1=preparedStatementObject.executeUpdate();
				System.out.println("Ticket Inserted "+temp1);
			
				flightObject.setAvailableSeats(selectFlight(ticketValue).getAvailableSeats());
				flag=updateFlightInsertFlight(ticketValue,-1);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				connectionObject.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		return flag;
	}
	public ArrayList<Ticket> selectTicketByUser(Ticket ticketValue) {
		ArrayList<Ticket> ticket=new ArrayList<Ticket>();
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		String query=null;
		try {
			try {
				query="select * from ticket where user_id=?";
				preparedStatementObject=connectionObject.prepareStatement(query);
				preparedStatementObject.setInt(1,ticketValue.getUserId());
				ResultSet resultSetObject=preparedStatementObject.executeQuery();
				while(resultSetObject.next()) {
					Ticket temporaryTicket=new Ticket();
					temporaryTicket.setUserId(resultSetObject.getInt(1));
					temporaryTicket.setTicketId(resultSetObject.getInt(2));
					temporaryTicket.setPassengerName(resultSetObject.getString(3));
					temporaryTicket.setFlightId(resultSetObject.getInt(4));
					temporaryTicket.setDepDate(resultSetObject.getDate(5));
					temporaryTicket.setDepTime(resultSetObject.getString(6));
					temporaryTicket.setStatus(com.aspire.travelexploration.Status.valueOf(resultSetObject.getString(7)));
					temporaryTicket.setDateOfBooking(resultSetObject.getDate(8));
					temporaryTicket.setFlightClass(com.aspire.travelexploration.FlightE.valueOf(resultSetObject.getString(9)));
					ticket.add(temporaryTicket);
				}
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}finally {
			try {
				connectionObject.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		return ticket;
	}
	public boolean cancelTicket(Ticket ticketValue) {
		boolean flag=false;
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		Ticket ticketObject=new Ticket();
		
		String query=null;
		try {
			query="select * from ticket where ticket_id=?";
			preparedStatementObject=connectionObject.prepareStatement(query);
			preparedStatementObject.setInt(1,ticketValue.getTicketId());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			while(resultSetObject.next()) {
				ticketObject.setTicketId(resultSetObject.getInt(1));
				ticketObject.setUserId(resultSetObject.getInt(2));
				ticketObject.setFlightId(resultSetObject.getInt(4));
				if(updateTicketCancelFlight(ticketObject,1))	flag=true;
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				connectionObject.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public Flight selectFlight(Ticket ticketValue) {
		Flight flightObject=new Flight();
		try {
			Connection connectionObject=ConnectionFactorySql.getSQLConnection();
			PreparedStatement preparedStatementObject;
			preparedStatementObject=connectionObject.prepareStatement("select * from flight where flight_id=?");
			preparedStatementObject.setInt(1,ticketValue.getFlightId());
			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			if(resultSetObject.next()) {
			    flightObject.setAvailableSeats(resultSetObject.getInt(17));
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flightObject;
	}
	public boolean updateFlightInsertFlight(Ticket ticketValue,int change) {
		Flight flightObject=new Flight();
		Ticket ticketObject=new Ticket();
		boolean flag=false;
		try {
			Connection connectionObject=ConnectionFactorySql.getSQLConnection();
			PreparedStatement preparedStatementObject;
			preparedStatementObject=connectionObject.prepareStatement("update flight set available_seats = ? where flight_id=?");
			preparedStatementObject.setInt(1,flightObject.getAvailableSeats()+change);
			preparedStatementObject.setInt(2,ticketObject.getFlightId());
			int temp=preparedStatementObject.executeUpdate();
			if(temp!=0) flag=true;
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	public boolean updateTicketCancelFlight(Ticket ticketValue,int change) {
		boolean flag=false;
		int temp;
		Connection connectionObject=ConnectionFactorySql.getSQLConnection();
		PreparedStatement preparedStatementObject;
		try {
			preparedStatementObject=connectionObject.prepareStatement("update ticket set status = 'CANCELLED' where ticket_id=?");
			preparedStatementObject.setInt(1,ticketValue.getTicketId());
			temp=preparedStatementObject.executeUpdate();
			if(temp!=0) flag=true;
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return flag;
	}
	
}
