package com.aspire.travelexploration.entity;

public class TourPackage {
	private int packageId;
	private String agencyName;
	private String assistancePerson;
	private String place;
	private int pricing;
	private int days;
	private int nights;
	private String itinerary;
	private String country;
	private String periodOfPackage;
	private String holidayType;
	private String packageType;
	private String tagLine1;
	private String tagLine2;
	private byte[] img;
	public int getPackage_id() {
		return packageId;
	}
	public void setPackage_id(int packageIdValue) {
		if(packageIdValue!=0)
			packageId = packageIdValue;
	}
	public String getAgency_name() {
		return agencyName;
	}
	public void setAgency_name(String agencyNameValue) {
		if(agencyNameValue!=null)
			agencyName = agencyNameValue;
	}
	public String getAssistance_Person() {
		return assistancePerson;
	}
	public void setAssistance_Person(String assistancePersonValue) {
		assistancePerson = assistancePersonValue;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String placeValue) {
		place = placeValue;
	}
	public int getPricing() {
		return pricing;
	}
	public void setPricing(int pricingValue) {
		pricing = pricingValue;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int daysValue) {
		days = daysValue;
	}
	public int getNights() {
		return nights;
	}
	public void setNights(int nightsValue) {
		nights = nightsValue;
	}
	public String getItinerary() {
		return itinerary;
	}
	public void setItinerary(String itineraryValue) {
		itinerary = itineraryValue;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String countryValue) {
		country = countryValue;
	}
	public String getPeriod_of_Package() {
		return periodOfPackage;
	}
	public void setPeriod_of_Package(String periodOfPackageValue) {
		periodOfPackage = periodOfPackageValue;
	}
	public String getHoliday_type() {
		return holidayType;
	}
	public void setHoliday_type(String holidayTypeValue) {
		holidayType = holidayTypeValue;
	}
	public String getPackage_type() {
		return packageType;
	}
	public void setPackage_type(String packageTypeValue) {
		packageType = packageTypeValue;
	}
	public String getTagline1() {
		return tagLine1;
	}
	public void setTagline1(String tagLine1Value) {
		tagLine1 = tagLine1Value;
	}
	public String getTagline2() {
		return tagLine2;
	}
	public void setTagline2(String tagLine2Value) {
		tagLine2 = tagLine2Value;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] imgValue) {
		this.img = imgValue;
	}
}
