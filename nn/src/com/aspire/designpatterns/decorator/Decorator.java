package com.aspire.designpatterns.decorator;

public abstract class Decorator implements Reader{
	protected Reader reader;
	
	public Decorator(Reader reader) {
		this.reader = reader;
	}
}
