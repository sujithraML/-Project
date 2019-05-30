package com.aspire.designpatterns.proxy;

public class PrinterProxy implements Printablee{
	Printerr printer = new Printerr();
	@Override
	public void printt() {
		printer.printt();
	}

}
