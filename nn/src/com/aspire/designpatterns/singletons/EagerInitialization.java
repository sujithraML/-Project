package com.aspire.designpatterns.singletons;

public class EagerInitialization implements Cloneable{
	private static EagerInitialization object = new EagerInitialization();
//	private static final EagerInitialization object = new EagerInitialization();
	private static String string;
	private EagerInitialization() {
		if(object != null) {
			throw new IllegalStateException("instance already created");
		}
	}
	/*thread-safe:can be used when the class is simple*/
	public static EagerInitialization getInstance() {
		return object;
	}
	{
		string = new String("Static Block");
		System.out.println(string);
	}
	protected Object clone() throws CloneNotSupportedException {
		return getInstance();
	}
}
