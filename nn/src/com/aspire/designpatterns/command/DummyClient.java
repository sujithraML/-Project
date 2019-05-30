package com.aspire.designpatterns.command;

public class DummyClient {
	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	public void command() {
		command.excecute();
	}
}
