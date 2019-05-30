package com.aspire.designpatterns.mediator;

public interface Mediator {
	public void sendMessage(String message, User user);
	void addUser(User user);
}
