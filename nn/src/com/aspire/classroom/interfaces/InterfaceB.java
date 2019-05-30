package com.aspire.classroom.interfaces;

public interface InterfaceB {
	
	default void print()
	{
		System.out.println("Default method B");
	}
}
