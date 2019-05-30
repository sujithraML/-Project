package com.aspire.travelexploration.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aspire.travelexploration.dao.ConnectionFactoryMySql;
import com.aspire.travelexploration.dao.JdbcInterface;
import com.aspire.travelexploration.entity.Flight;
import com.aspire.travelexploration.entity.Ticket;
import com.aspire.travelexploration.enums.FlightE;
import com.aspire.travelexploration.enums.Status;
public class TicketDAO implements JdbcInterface{

	public ArrayList<Ticket> selectTicketByUser(Ticket ticketValue) {
		ArrayList<Ticket> tickets=new ArrayList<Ticket>();
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		String query=null;
		try {
			query="select * from ticket where user_id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,ticketValue.getUserId());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Ticket ticket=new Ticket();
				ticket.setUserId(resultSet.getInt(1));
				ticket.setTicketId(resultSet.getInt(2));
				ticket.setPassengerName(resultSet.getString(3));
				ticket.setFlightId(resultSet.getInt(4));
				ticket.setDepDate(resultSet.getDate(5));
				ticket.setDepTime(resultSet.getString(6));
				ticket.setStatus(Status.valueOf(resultSet.getString(7)));
				ticket.setDateOfBooking(resultSet.getDate(8));
				ticket.setFlightClass(FlightE.valueOf(resultSet.getString(9)));
				tickets.add(ticket);
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return tickets;
	}
	public boolean cancelTicket(Ticket ticket) {
		boolean flag=false;
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		Flight flight=new Flight();
		try {
			preparedStatement=connection.prepareStatement("update ticket set status = 'CANCELLED' where ticket_id=?");
			preparedStatement.setInt(1,ticket.getTicketId());
			int row=preparedStatement.executeUpdate();
			if(row!=0) {
				flight=selectFlight(ticket);
				flag=updateFlight(flight,ticket,1);
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	private Flight selectFlight(Ticket ticketValue) {
		Flight flight=new Flight();
		try {
			Connection connection=ConnectionFactoryMySql.getSQLConnection();
			PreparedStatement preparedStatement;
			preparedStatement=connection.prepareStatement("select available_seats from flight where flight_id=?");
			preparedStatement.setInt(1,ticketValue.getFlightId());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
			    flight.setAvailableSeats(resultSet.getInt(1));
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flight;
	}
	private boolean updateFlight(Flight flight,Ticket ticket,int change) {
		boolean flag=false;
		try {
			Connection connection=ConnectionFactoryMySql.getSQLConnection();
			PreparedStatement preparedStatement;
			preparedStatement=connection.prepareStatement("update flight set available_seats = ? where flight_id=?");
			preparedStatement.setInt(1,flight.getAvailableSeats()+change);
			preparedStatement.setInt(2,ticket.getFlightId());
			int temp=preparedStatement.executeUpdate();
			if(temp!=0) flag=true;
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	public boolean updateTicket(Ticket ticketValue,int change) {
		boolean flag=false;
		int temp;
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement("update ticket set status = 'CANCELLED' where ticket_id=?");
			preparedStatement.setInt(1,ticketValue.getTicketId());
			temp=preparedStatement.executeUpdate();
			if(temp!=0) flag=true;
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean addDetails(Object object) {
		Connection connection=ConnectionFactoryMySql.getSQLConnection();
		Flight flight=new Flight();
		Ticket ticket=(Ticket)object;
		int temp1;
		boolean flag=false;
		
		PreparedStatement preparedStatement=null;
		try {
			String qry="insert into ticket values(?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(qry);
			System.out.println("queryInsert:");
				preparedStatement.setInt(1,ticket.getTicketId());
				preparedStatement.setInt(2,ticket.getUserId());
				preparedStatement.setString(3,ticket.getPassengerName());
				preparedStatement.setInt(4, ticket.getFlightId());
				preparedStatement.setDate(5, (Date) ticket.getDepDate());
				preparedStatement.setString(6, ticket.getDepTime());
				preparedStatement.setString(7, ticket.getStatus().toString());
				preparedStatement.setDate(8, (Date) ticket.getDateOfBooking());
				preparedStatement.setString(9, ticket.getFlightClass().toString());
				temp1=preparedStatement.executeUpdate();
				System.out.println("Ticket Inserted "+temp1);
			
				flight=selectFlight(ticket);
				flag=updateFlight(flight,ticket,-1);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Object> selectDetails(Object object) {
		List<Object> tickets=new ArrayList<Object>();
		Ticket ticketId=new Ticket();
		ticketId=(Ticket)object;
		Connection connectionObject=ConnectionFactoryMySql.getSQLConnection();
		PreparedStatement preparedStatement;
		String query=null;
			try {
				query="select * from ticket where user_id=?";
				preparedStatement=connectionObject.prepareStatement(query);
				preparedStatement.setInt(1,ticketId.getUserId());
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					Ticket ticket=new Ticket();
					ticket.setUserId(resultSet.getInt(2));
					ticket.setTicketId(resultSet.getInt(1));
					ticket.setPassengerName(resultSet.getString(3));
					ticket.setFlightId(resultSet.getInt(4));
					ticket.setDepDate(resultSet.getDate(5));
					ticket.setDepTime(resultSet.getString(6));
					ticket.setStatus(Status.valueOf(resultSet.getString(7)));
					ticket.setDateOfBooking(resultSet.getDate(8));
					ticket.setFlightClass(FlightE.valueOf(resultSet.getString(9)));
					tickets.add(ticket);
				}
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		return tickets;
	}
}
