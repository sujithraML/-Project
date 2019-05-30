package com.aspire.travelexploration;

import java.util.Date;

public class Flight {
	int flightId;
	int airlineId;
	String airLineName;
	byte[] airlineLogo;
	String fromLocation;
	String toLocation;
	String departureTime;
	String arrivalTime;
	String duration;
	int totalSeats;
	String baggageAllowance;
	float taxes;
	FlightE flightClass;
	int stoppages;
	Date depDate;
	int price;
	int availableSeats;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightIdValue) {
		if(flightIdValue!=0 && flightIdValue>2000)
			flightId = flightIdValue;
		else
			System.out.println("Enter valid flight id");
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineIdValue) {
		if(airlineIdValue!=0 && airlineIdValue>1000)
			airlineId = airlineIdValue;
		else
			System.out.println("Enter valid flight id");
	}
	public String getAirLineName() {
		return airLineName;
	}
	public void setAirLineName(String airLineNameValue) {
		if(airLineNameValue!=null && airLineNameValue.length()>3)
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
		if(fromLocationValue!=null && fromLocationValue.length()==3)
			fromLocation = fromLocationValue;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocationValue) {
		if(toLocationValue!=null && toLocationValue.length()==3)
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
