package com.aspire.designpatterns.proxy;

public class Test {

	public static void main(String[] args) {
		Printablee printable=new PrinterProxy();
		printable.printt();
		System.out.println("test ended");
	}

}
