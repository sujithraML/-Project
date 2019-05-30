package com.aspire.travelexploration.entity;

public class FlightDeal {
	private String couponCode;
	private String offerDetails;
	private int minimumBookingAmount;
	private String bookingChannel;
	private String applicableBanks;
	private String validity;
	private String tagLine;
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCodeValue) {
		if(couponCodeValue!=null)
			couponCode = couponCodeValue;
	}
	public String getOfferDetails() {
		return offerDetails;
	}
	public void setOfferDetails(String offerDetailsValue) {
		if(offerDetailsValue!=null)
			offerDetails = offerDetailsValue;
	}
	public int getMinimumBookingAmount() {
		return minimumBookingAmount;
	}
	public void setMinimumBookingAmount(int minimumBookingAmountValue) {
		if(minimumBookingAmountValue!=0)
			minimumBookingAmount = minimumBookingAmountValue;
	}
	public String getBookingChannel() {
		return bookingChannel;
	}
	public void setBookingChannel(String bookingChannelValue) {
		if(bookingChannelValue!=null)
			bookingChannel = bookingChannelValue;
	}
	public String getApplicableBanks() {
		return applicableBanks;
	}
	public void setApplicableBanks(String availableBanksValue) {
		if(availableBanksValue!=null)
			applicableBanks = availableBanksValue;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validityValue) {
		if(validityValue!=null)
			validity = validityValue;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLineValue) {
		if(tagLineValue!=null)
			tagLine = tagLineValue;
	}
}
