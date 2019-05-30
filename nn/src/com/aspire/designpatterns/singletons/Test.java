package com.aspire.designpatterns.singletons;


public class Test {
	public static void main(String[] args) {
		//tests eager Initialization
		EagerInitialization first = EagerInitialization.getInstance();
		EagerInitialization second = EagerInitialization.getInstance();
		System.out.println("eager Initialization \t"+first.hashCode()+"\t"+second.hashCode());
		
		//tests Lazy Initialization
		LazyInitialization firstLazy = LazyInitialization.getInstance();
		LazyInitialization secondLazy = LazyInitialization.getInstance();
		System.out.println("Lazy Initialization \t"+firstLazy.hashCode()+"\t"+secondLazy.hashCode());
		
		//tests Synchronized Method
		SynchronizedMethod firstSynchronized = SynchronizedMethod.getInstance();
		SynchronizedMethod secondSynchronized = SynchronizedMethod.getInstance();
		System.out.println("Synchronized Method \t"+firstSynchronized.hashCode()+"\t"+secondSynchronized.hashCode());
		
		//tests BillPugh Method
		BillPughSingleton firstObject = BillPughSingleton.getInstance();
		BillPughSingleton secondObject = BillPughSingleton.getInstance();
		System.out.println("BillPugh Method \t"+firstObject.hashCode()+"\t"+secondObject.hashCode());
		
		//tests Double Check Synchronized
		DoubleCheckSynchronized one = DoubleCheckSynchronized.getInstance();
		DoubleCheckSynchronized two = DoubleCheckSynchronized.getInstance();
		System.out.println("Double Check Method \t"+one.hashCode()+"\t"+two.hashCode());
		
		//tests Enum method
		EnumMethod.OBJECT.setString("True");
		EnumMethod.OBJECT.Printit();
		EnumMethod.OBJECT.setString("False");
		EnumMethod.OBJECT.Printit();
		EnumMethod.OBJECT.Printit();
	}
}
