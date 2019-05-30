package com.aspire.classroom.assignments;

import java.util.Comparator;

public class NameComp implements Comparator<Contact>{

	@Override
	public int compare(Contact contactObj1, Contact contactObj2) {
		 return(contactObj1.getContactName().compareTo(contactObj2.getContactName()));
	}	
}
