package com.aspire.designpatterns.command;

public class SendMessage implements Command{
	String message;
	
	Receiver receiver;
	
	SendMessage(){
		
	}
	SendMessage(String message){
		this.message = message;
	}
	public void setCommand(Receiver receiver) {
		
	}
	@Override
	public void excecute() {
	//	receiver.setMessage(message);
	//	receiver.sendInfo();
	}
}
