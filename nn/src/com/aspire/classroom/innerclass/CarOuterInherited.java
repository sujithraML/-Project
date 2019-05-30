package com.aspire.classroom.innerclass;

public class CarOuterInherited extends CarOuter{
	public void printCarOuter() {
		System.out.println("Inherited Class public");
	}
	protected void printCarOuterr() {
		System.out.println("Inherited Class protected");
	}
	void printCarOuterrr() {
		System.out.println("Inherited Class default");
	}
	private void printCarOuterrrr() {
		System.out.println("Inherited Class private");
	}
}
