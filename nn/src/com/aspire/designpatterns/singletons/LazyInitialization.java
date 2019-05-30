package com.aspire.designpatterns.singletons;

public class LazyInitialization {
	private static LazyInitialization object;
	
	private LazyInitialization() {
		
	}
	
	/*Object gets created when needed
	  But not thread-safe i.e when two threads attempts to create the instances
	  end up creating two instances of the class*/
	
	public static LazyInitialization getInstance() {
		
		if(object==null) {
			object = new LazyInitialization();
		}
		return object;
	}
}
