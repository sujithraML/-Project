package com.aspire.designpatterns.decorator;

public class StringReader implements Reader{
	private static String string;
	
	StringReader(String string){
		this.string = string;
	}

	@Override
	public void read() {
		System.out.println("content of the file is"+string);
	}
}
