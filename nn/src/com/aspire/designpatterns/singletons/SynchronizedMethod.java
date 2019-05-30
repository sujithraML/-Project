package com.aspire.designpatterns.singletons;

public class SynchronizedMethod {
	private static SynchronizedMethod object;
	
	private SynchronizedMethod() {
		
	}
	/*synchronization is expensive: can use if performance is not critical*/
	synchronized public static SynchronizedMethod getInstance() {
		if(object == null)
			object = new SynchronizedMethod();
		return object;
	}
}
