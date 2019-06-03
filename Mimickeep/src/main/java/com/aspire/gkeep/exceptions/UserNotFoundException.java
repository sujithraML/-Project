package com.aspire.gkeep.exceptions;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8413661826596921208L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
