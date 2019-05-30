package com.aspire.travelexploration;

public class TourPackage {
	int agencyId;
	String agencyName;
	String assistancePerson;
	String place;
	int pricing;
	int days;
	int nights;
	String itinerary;
	String country;
	String periodOfPackage;
	String holidayType;
	String packageType;
	String tagLine1;
	String tagLine2;
	byte[] img;
	public int getAgency_id() {
		return agencyId;
	}
	public void setAgency_id(int agencyIdValue) {
		if(agencyIdValue!=0)
			agencyId = agencyIdValue;
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
