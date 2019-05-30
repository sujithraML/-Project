package com.aspire.designpatterns.command;

public abstract class Receiver {
	protected String recieverName;
	
	public Receiver( String name) {
		this.recieverName = name;
	}
	
	abstract void open();
	
	abstract void close();
}
