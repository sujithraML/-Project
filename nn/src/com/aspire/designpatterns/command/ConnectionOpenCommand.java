package com.aspire.designpatterns.command;

public class ConnectionOpenCommand implements Command{

	private Receiver receiver;
	
	ConnectionOpenCommand(Receiver receiver){
		this.receiver = receiver;
	}
	@Override
	public void excecute() {
		receiver.open();
	}
	
}
