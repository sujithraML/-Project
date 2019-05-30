package com.aspire.designpatterns.singletons;

public class DoubleCheckSynchronized {
	/*volatile is present in main memory
	 * volatile is synchronized itself*/
	
	private volatile static DoubleCheckSynchronized object =null;
	
	public static DoubleCheckSynchronized getInstance() {
		if(object == null) {
			
			/* when the object is null it will acquire the lock so other threads could not access it
			 * synchronized will not get called every time
			 * can be used for high performance multi-threaded application*/
			
			synchronized (DoubleCheckSynchronized.class) {
				if(object ==null) {
					object = new DoubleCheckSynchronized();
				}
			}
		}
		return object;
	}
}
