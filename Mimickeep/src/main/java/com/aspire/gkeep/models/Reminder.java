package com.aspire.gkeep.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class Reminder {
	private String message;
	private String datetime;
	
	public Reminder(){
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		if(datetime.equals("")) {
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
			this.datetime = timeFormat.format(LocalDateTime.now());
		}
		else
			this.datetime = datetime;
	}
}
