package com.aspire.classroom.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
public class PhoneBookList implements Comparator<Contact>{
		
		ArrayList <Contact> contactPersons=new ArrayList <Contact>();
		
		public void beforeAdd() {
			contactPersons=getDataSql();
		}
		
		public void add(String nameValue,long numberValue){
			Contact c1=new Contact();
			boolean flag=false;
//			contactPersons.addAll(oldList);
			Iterator <Contact> itrObjj=contactPersons.iterator();
				if(itrObjj.hasNext()) {
					while(itrObjj.hasNext()) {
						Contact abObj=itrObjj.next();
						if(numberValue==abObj.getContactNumber()) {
							flag=true;
						}
					}
				}
				if(flag==false)	{
				c1.setContactName(nameValue);
				c1.setContactNumber(numberValue);
					contactPersons.add(c1);	
					Collections.sort(contactPersons, new NameComp());
					//Collections.sort(contactPersons,Contact.noComparator);
				}
		}
		public void removeDuplicates() {
//			Iterator <Contact> itrObjj=contactPersons.iterator();
//			if(itrObjj.hasNext()) {
//				while(itrObjj.hasNext()) {
//					Contact abObj=itrObjj.next();
//				}
//			}
				
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
		
		public void update(long numberValue,long newNumberValue,String newName) {

			Iterator <Contact> itrObjj=contactPersons.iterator();
			Contact abObject = null;
			int i=0;
			
			while(itrObjj.hasNext()) {
				i++;
				Contact abObj=itrObjj.next();
				abObject=abObj;
				if(abObj.getContactNumber()==numberValue) {
						contactPersons.remove(i);
				}
			}
			if(newName!=null) {
				Contact c1=new Contact();
				c1.setContactName(abObject.getContactName());
				c1.setContactNumber(newNumberValue);
				
				contactPersons.add(c1);
			}
			else {  
				Contact c1=new Contact();
				c1.setContactName(newName);
				c1.setContactNumber(abObject.getContactNumber());
				
				contactPersons.add(c1);
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
					contactPersons.remove(i);
					}
				}
			}
		}
		
		public void display() {
			System.out.println("In the arrayList");
			Iterator <Contact> itrObj=contactPersons.iterator();
			while(itrObj.hasNext()) {
				System.out.println(itrObj.next());
			}
		}
		public void fileInto() {
			FileIO file=new FileIO();
			file.fileIn(contactPersons);
			file.fileOut();
		}
		public ArrayList<Contact> getDataSql() {
			QuerySql query=new QuerySql();
			ArrayList <Contact> oldList=new ArrayList();
			oldList=query.querySelect(contactPersons);
			return oldList;
		}
		public void jdbcInto() {
			QuerySql query=new QuerySql();
			query.queryInsert(contactPersons);
			query.querySelect(contactPersons);
		}

		@Override
		public int compare(Contact contactObj1, Contact contactObj2) {
			 if(contactObj1.getContactNumber()==contactObj2.getContactNumber()) {
				 return 0;
			 }
			 return 1;
		}	
}
