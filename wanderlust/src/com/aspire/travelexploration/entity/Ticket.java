package com.aspire.travelexploration.entity;

import java.util.Date;

import com.aspire.travelexploration.enums.FlightE;
import com.aspire.travelexploration.enums.Status;

public class Ticket {
	private int ticketId;
	private int userId;
	private String passengerName;
	private int flightId;
	private Date depDate;
	private String depTime;
	private Status status;
	private Date dateOfBooking;
	private FlightE flightClass;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketIdValue) {
		if(ticketIdValue!=0)
			ticketId = ticketIdValue;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userIdValue) {
		if(userIdValue!=0)
			userId = userIdValue;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerNameValue) {
		if(passengerNameValue!=null)
			passengerName = passengerNameValue;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightIdValue) {
		if(flightIdValue!=0)
			flightId = flightIdValue;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDateValue) {
		depDate = depDateValue;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTimeValue) {
		if(depTimeValue!=null)
			depTime = depTimeValue;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status statusValue) {
		status = statusValue;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBookingValue) {
		dateOfBooking = dateOfBookingValue;
	}
	public FlightE getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(FlightE flightClassValue) {
		flightClass = flightClassValue;
	}
}
