package com.aspire.classroom.collectionsall;

import java.util.ArrayList;
import java.util.List;

public class TriedArrayList {
	List<Object> arrayList=new ArrayList<Object>();
	public void store() {
		arrayList.add(0, null);
		arrayList.add(2,"two");
		arrayList.add(3,1.46);
		arrayList.add(4,'t');
		arrayList.add(5,1.444444444444);
		arrayList.add(6,1010101010);
	}
	public void disp() {
		System.out.println(arrayList);
	}

}
