package com.aspire.classroom.assignments;

import java.util.Comparator;

public class Contact {
	private String contactName;
	private long contactNumber;

	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactNameValue) {
		if(contactNameValue!=null) {
			if(contactNameValue.matches("[a-zA-Z]*")) {
				if(contactNameValue.length()>3 && contactNameValue.length()<20) {
					contactName=contactNameValue;
				}
				else
					System.out.println("Enter valid name");
			}
			else
				System.out.println("Enter valid name");
		}
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumberValue) {
		long tempno=contactNumberValue;
		if((long)Math.log10(tempno)+1==10)
			contactNumber=contactNumberValue;
		else
			System.out.println("invalid phone number");
	}
	public String toString() {
		return this.contactName+" "+this.contactNumber;
	}
	public static Comparator<Contact> noComparator=new Comparator<Contact>(){
		 @Override         
		    public int compare(Contact contactObj1, Contact contactObj2) {             
		      return (contactObj2.getContactNumber() == contactObj1.getContactNumber() ? 0 : 1);           
		    } 
	};
	public static Comparator<Contact> nameComparator=new Comparator<Contact>(){
		 @Override         
		    public int compare(Contact contactObj1, Contact contactObj2) {             
		      return  (contactObj2.getContactName() == contactObj1.getContactName() ? 0 : 1);           
		    } 
	};
}
