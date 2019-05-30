package com.aspire.designpatterns.decorator;

public class Demo {

	public static void main(String[] args) {
		Reader reader = new StringReader("null null");
		reader.read();
		
		Reader oneMoreReader = new TrimDecorator(reader);
		oneMoreReader.read();
	}

}
