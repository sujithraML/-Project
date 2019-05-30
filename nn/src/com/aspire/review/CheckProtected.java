package com.aspire.review;

import java.util.ArrayList;
import java.util.List;

import com.aspire.reviewassignments.DiffOverloading;

public class CheckProtected {
	public static void main(String[] args) {
		DiffOverloading object=new DiffOverloading();
		object.display(2);
		List<String> list=new ArrayList<String>();
		
		list.add("harrison wells");
		list.add("sheldon cooper");
		list.add("Amy");
		list.add("Oswald");
		
		ArrayList<String> arrayList=new ArrayList<String>(3);
		System.out.println(arrayList.size()); 
		
		arrayList.addAll(list);
		System.out.println(arrayList.size()); 
		
//		ArrayList<Integer> sameSizeList=Arrays.asList(new Integer(10));
//		sameSizeList.add("third arraylist");
		//object.display("display");
	}
}
