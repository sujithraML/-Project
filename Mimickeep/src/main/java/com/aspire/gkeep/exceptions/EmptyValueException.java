package com.aspire.gkeep.exceptions;

public class EmptyValueException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5685339852814107687L;

	public EmptyValueException( String message, Throwable cause){
		super(message, cause);
	}
}
