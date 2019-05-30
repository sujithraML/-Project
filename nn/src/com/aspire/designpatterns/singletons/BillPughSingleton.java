package com.aspire.designpatterns.singletons;


// thread-safe approach even without expensive synchronization
public class BillPughSingleton {
	//int count=0;
	private BillPughSingleton() {
		
	}
	public static BillPughSingleton getInstance() {
		return InnerBillPugh.object;
	}
		private static class InnerBillPugh {
			private static final BillPughSingleton object =new BillPughSingleton();
		}
}
