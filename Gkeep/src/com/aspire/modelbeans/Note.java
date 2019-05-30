package com.aspire.modelbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Note {
	private String message;
	private String entryDate;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		DateFormat dateFormat = new SimpleDateFormat("DD/MM/YY HH:MM:SS");
		this.entryDate = dateFormat.format(LocalDateTime.now());
	}
}
