package com.aspire.designpatterns.command;

public class ConnectionCloseCommand implements Command{

	private Receiver receiver;
	
	ConnectionCloseCommand(Receiver receiver){
		this.receiver = receiver;
	}
	
	@Override
	public void excecute() {
		receiver.close();
	}
	
}
