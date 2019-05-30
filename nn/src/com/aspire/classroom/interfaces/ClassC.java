package com.aspire.classroom.interfaces;

public class ClassC implements InterfaceA, InterfaceB {

	@Override
	public void print() {

		System.out.println("Overriden method in Class c");
		InterfaceB.super.print();
		InterfaceA.super.print();
	}

	public void displ() {
		InterfaceA.super.print();
	}

	static void methodSample()
	{
		System.out.println("Inside Static Method");
	}
	public static void main(String[] args) {

		ClassC objC = new ClassC();
		objC.print();
		objC.displ();
		objC.show();
		InterfaceA.display();
		methodSample();
	}

	@Override
	public void show() {
		System.out.println("Interface A overidden method show");
	}

}
