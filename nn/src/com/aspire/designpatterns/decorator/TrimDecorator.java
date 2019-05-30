package com.aspire.designpatterns.decorator;

public class TrimDecorator extends Decorator{

	public TrimDecorator(Reader reader) {
		super(reader);
	}
	public void read() {
		System.out.println("the content is : ");
		this.reader.read();
	}
}
