package com.aspire.travelexploration;

public class Trip {
	int tripId;
	int userId;
	String country;
	String state;
	String placeName;
	String placeType;
	String specialities;
	byte[] picture1;
	byte[] picture2;
	byte[] picture3;
	byte[] picture4;
	byte[] picture5;
	byte[] picture6;
	String review;
	int rating;
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripIdValue) {
		if(tripIdValue!=0)
			tripId = tripIdValue;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userIdValue) {
		if(userIdValue!=0)
			userId = userIdValue;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String countryValue) {
		if(countryValue!=null)
			country = countryValue;
	}
	public String getState() {
		return state;
	}
	public void setState(String stateValue) {
		if(stateValue!=null)
			state = stateValue;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeNameValue) {
		if(placeNameValue!=null)
			placeName = placeNameValue;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeTypeValue) {
		if(placeTypeValue!=null)
			placeType = placeTypeValue;
	}
	public String getSpecialities() {
		return specialities;
	}
	public void setSpecialities(String specialitiesValue) {
		if(specialitiesValue!=null)
			specialities = specialitiesValue;
	}
	public byte[] getPicture1() {
		return picture1;
	}
	public void setPicture1(byte[] picture1Value) {
		if(picture1Value!=null)
			picture1 = picture1Value;
	}
	public byte[] getPicture2() {
		return picture2;
	}
	public void setPicture2(byte[] picture2Value) {
		if(picture2Value!=null)
			picture2 = picture2Value;
	}
	public byte[] getPicture3() {
		return picture3;
	}
	public void setPicture3(byte[] picture3Value) {
		if(picture3Value!=null)
			picture3 = picture3Value;
	}
	public byte[] getPicture4() {
		return picture4;
	}
	public void setPicture4(byte[] picture4Value) {
		if(picture4Value!=null)
			picture4 = picture4Value;
	}
	public byte[] getPicture5() {
		return picture5;
	}
	public void setPicture5(byte[] picture5Value) {
		if(picture5Value!=null)
			picture5 = picture5Value;
	}
	public byte[] getPicture6() {
		return picture6;
	}
	public void setPicture6(byte[] picture6Value) {
		if(picture6Value!=null)
			picture6 = picture6Value;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String reviewValue) {
		if(reviewValue!=null)
			review = reviewValue;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int ratingValue) {
		if(ratingValue!=0)
			rating = ratingValue;
	}
}
