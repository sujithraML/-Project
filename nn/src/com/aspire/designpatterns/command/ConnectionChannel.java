package com.aspire.designpatterns.command;

public class ConnectionChannel extends Receiver{
	
	String message;
	
	public ConnectionChannel(String message) {
		super(message);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public void open() {
		System.out.println("Connection Open");
	}
	
	public void close() {
		System.out.println("Connection closed");
	}
	
	public void sendInfo() {
		System.out.println("Sending "+message);
	}
	
	public void listenInfo() {
		
	}
}
