package com.aspire.classroom.interfaces;

public interface InterfaceA {
	
	default void print()
	{
		System.out.println("Default method A");
	}
	
	abstract void show();
	
	static void display()
	{
		System.out.println("Static method");
	}
}
