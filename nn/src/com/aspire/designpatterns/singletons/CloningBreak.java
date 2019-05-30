package com.aspire.designpatterns.singletons;

public class CloningBreak {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		EagerInitialization one = EagerInitialization.getInstance();
		EagerInitialization two = (EagerInitialization) one.clone();
		
		System.out.println("First : "+one.hashCode()+"\nSecond : "+two.hashCode());
		
	}

}
