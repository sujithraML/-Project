package com.aspire.designpatterns.factory;

public class FlairPen extends Flair{
	int nibThickness;
	FlairPen(){
		
	}
	public void write() {
		System.out.println(logo+"\tItalics");
	}
}
