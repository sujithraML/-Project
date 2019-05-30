package com.aspire.classroom.wrapperc;

public class WrapperC {
	public static void main(String args[]) {
		Integer object1=new Integer(10);
		Float object2=Float.valueOf(100);
		int value1=object1.intValue();
		float value2=object2.floatValue();
		System.out.println(value1+ " " + value2);
		object1=Integer.valueOf(value1);
		System.out.println(object1);
		
	}
}
