package com.aspire.classroom.groupingobj;

public class TriedArray {
		int [] a=new int[10];
		int i=0;
		Object [] arrObj=new Object[10];
		Object [] strObj=new String[10];
		//String [] strarrObj=new Object[10];//no down casting
		//int [] c=new String[10];	//type mismatch
		//String [] b=new int[10];	//type mismatch
		public void store() {
			for(i=0;i<5;i++) {
				strObj[i]=new String();
				strObj[i]=""+i;
				System.out.println(strObj[i]);
			}
			for(i=5;i<10;i++) {
				strObj[i]=new String();
				strObj[i]="hello";
				System.out.println(strObj[i]);
			}
		}

}
