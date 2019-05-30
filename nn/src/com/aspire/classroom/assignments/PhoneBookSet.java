package com.aspire.classroom.assignments;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookSet {
	

		TreeSet <Contact> contactPersons=new TreeSet <Contact> (new NameComp());
		
	public void add(String nameValue,long numberValue){
			Contact c1=new Contact();
			c1.setContactName(nameValue);
			c1.setContactNumber(numberValue);
				contactPersons.add(c1);	
	}
	public void search(String nameValue,long numberValue) {
		
		Iterator <Contact> itrObj=contactPersons.iterator();
		while(itrObj.hasNext()) {
			Contact abObj=itrObj.next();
			if(abObj.getContactName().equals(nameValue)) {
				if(abObj.getContactNumber()==numberValue) {
					System.out.println(abObj);
				}
			}
		}
	}
	public void update(long numberValue) {

		Iterator <Contact> itrObjj=contactPersons.iterator();
		Scanner sc=new Scanner(System.in);
		Contact abObject = null;
		int i=0;
		
		while(itrObjj.hasNext()) {
			i++;
			Contact abObj=itrObjj.next();
			abObject=abObj;
			if(abObj.getContactNumber()==numberValue) {
					contactPersons.remove(abObj);
			}
		}
		System.out.println("Do you want to update the 1.number 2.name");
		if(sc.nextInt()==1) {
			System.out.println("Enter the phone number");
			//contactPersons.add(new Contact(abObject.getContactName(),sc.nextLong()));
		}
		else if(sc.nextInt()==2) {
			System.out.println("Enter the name");
			//contactPersons.add(new Contact(sc.next(),abObject.getContactNumber()));
		}
		System.out.println("Successfully Updated");
	}
	public void remove(String nameValue,long numberValue) {	

		Iterator <Contact> itrObj2=contactPersons.iterator();
		int i=0;
		while(itrObj2.hasNext()) {
			i++;
		Contact abObj=itrObj2.next();
			if(abObj.getContactName().equals(nameValue)){
				if(abObj.getContactNumber()==numberValue) {
				contactPersons.remove(abObj);
				}
			}
		}
	}
	public void display() {
		Iterator <Contact> itrObj=contactPersons.iterator();
		while(itrObj.hasNext()) {
			System.out.println(itrObj.next());
		}
	}
	
}
