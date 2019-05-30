package com.aspire.designpatterns.mediator;

public abstract class User {
	protected Mediator mediator;
	
	protected String name;
	
	public abstract void sendMessage(String message);
	
	public abstract void receiveMessage(String message);

}
