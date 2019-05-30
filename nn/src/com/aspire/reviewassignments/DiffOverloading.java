package com.aspire.reviewassignments;

public class DiffOverloading {
	public void display() {
		System.out.println("no arguement");
	}
	public void display(int a) {
		System.out.println("Integer : "+a);
	}
	protected void display(String string) {
		System.out.println("String : "+string);
	}
}
