package com.aspire.travelexploration.entity;

import java.io.Serializable;
import java.sql.Date;

import com.aspire.travelexploration.enums.FlightE;



public class Flight implements Serializable{
	private static final long serialVersionUID = 1L;
	private int flightId;
	private int airlineId;
	private String airLineName;
	private byte[] airlineLogo;
	private String fromLocation;
	private String toLocation;
	private String departureTime;
	private String arrivalTime;
	private String duration;
	private int totalSeats;
	private String baggageAllowance;
	private float taxes;
	private FlightE flightClass;
	private int stoppages;
	private Date depDate;
	private int price;
	private int availableSeats;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightIdValue) {
		if(flightIdValue!=0)
			flightId = flightIdValue;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineIdValue) {
		if(airlineIdValue!=0)
			airlineId = airlineIdValue;
	}
	public String getAirLineName() {
		return airLineName;
	}
	public void setAirLineName(String airLineNameValue) {
		if(airLineNameValue!=null)
			airLineName = airLineNameValue;
	}
	public byte[] getAirlineLogo() {
		return airlineLogo;
	}
	public void setAirlineLogo(byte[] airlineLogoValue) {
		if(airlineLogoValue!=null)
			airlineLogo = airlineLogoValue;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocationValue) {
		if(fromLocationValue!=null)
			fromLocation = fromLocationValue;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocationValue) {
		if(toLocationValue!=null)
			toLocation = toLocationValue;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTimeValue) {
		if(departureTimeValue!=null)
			departureTime = departureTimeValue;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTimeValue) {
		if(arrivalTimeValue!=null)
			arrivalTime = arrivalTimeValue;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String durationValue) {
		if(durationValue!=null)
			duration = durationValue;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeatsValue) {
		if(totalSeatsValue!=0)
			totalSeats = totalSeatsValue;
	}
	public String getBaggageAllowance() {
		return baggageAllowance;
	}
	public void setBaggageAllowance(String baggageAllowanceValue) {
		if(baggageAllowanceValue!=null)
			baggageAllowance = baggageAllowanceValue;
	}
	public float getTaxes() {
		return taxes;
	}
	public void setTaxes(float taxesValue) {
		if(taxesValue!=0.0)
			taxes = taxesValue;
	}
	public FlightE getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(FlightE flightClassValue) {
		flightClass = flightClassValue;
	}
	public int getStoppages() {
		return stoppages;
	}
	public void setStoppages(int stoppagesValue) {
		if(stoppagesValue>=0 && stoppagesValue<3)
			stoppages = stoppagesValue;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDateValue) {
		depDate = depDateValue;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int priceValue) {
		if(priceValue!=0)
			price = priceValue;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeatsValue) {
		if(availableSeatsValue!=0)
			availableSeats = availableSeatsValue;
	}

}
