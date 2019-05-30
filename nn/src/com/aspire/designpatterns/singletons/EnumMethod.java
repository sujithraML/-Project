package com.aspire.designpatterns.singletons;

public enum EnumMethod {
	OBJECT;
	private String string;
	
	public void setString(String string) {
		this.string=string;
	}
	public void Printit() {
		System.out.println("The Instance created for : "+ this.string);
	}
}
