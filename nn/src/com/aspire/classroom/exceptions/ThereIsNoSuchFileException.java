package com.aspire.classroom.exceptions;

public class ThereIsNoSuchFileException {
	ThereIsNoSuchFileException(){
		
	}
	ThereIsNoSuchFileException(String string,Throwable cause){
		cause.fillInStackTrace();
	}
	ThereIsNoSuchFileException(String string,Exception e){
		e.printStackTrace();
	}
}
