package com.aspire.designpatterns.command; 	

public class TestClient {
	private Invoker invoker;
	
	private Command command;
	
	public static void main(String[] args) {
		TestClient client = new TestClient();
		client.run();
	}
	private void run() {
		Receiver receiver = new ConnectionChannel("ConnectionChannel");
		command = new ConnectionOpenCommand(receiver);
		invoker = new Invoker(command);
		invoker.executeCommand();
		
		//should send message
		
		command = new ConnectionCloseCommand(receiver);
		invoker = new Invoker(command);
		invoker.executeCommand();
	}
}
