package com.aspire.gkeep.exceptions;

public class UserNameUnAvailableException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4033781411693527666L;
	
	public UserNameUnAvailableException(String message) {
		super(message);
	}

	public UserNameUnAvailableException(String message, Throwable cause) {
		super(message, cause);
	}
}
