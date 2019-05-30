package com.aspire.classroom.groupingobj;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class HTable {
	
	public static void main(String args[]) {
		Hashtable<Integer,Integer> htObj=new Hashtable<Integer,Integer>();
		Vector <String> hashTable1[];
		//hashTable1[1].pushback("t");
		Hashtable hashTable2=new Hashtable();
		hashTable2.put(1, "a");
		hashTable2.put(2, "s");
		hashTable2.put(3, "p");
		ArrayList<String> arrayListObj=new ArrayList<String>();
		arrayListObj=(ArrayList<String>)hashTable2.clone();
		System.out.println(hashTable2);
	}
}
