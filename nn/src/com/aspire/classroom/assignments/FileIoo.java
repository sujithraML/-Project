//package com.aspire.classroom.assignments;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//
//public class FileIO<T>{	
//	public void fileIn(HashSet<T> phoneBook) {
//		
//		try {
//			File file = new File("phonebook.txt");
//			FileWriter fileWriter = new FileWriter(file);
//
//			//Iterator <Contact> itrObj=(Iterator<Contact>) phoneBook.iterator();
//			Iterator <Contact> itrObj=(Iterator<Contact>) phoneBook.iterator();
//			while(itrObj.hasNext()) {
//				Contact abObj=itrObj.next();
//				System.out.println(abObj.getContactName()+abObj.getContactNumber());
//				}
////			while(itrObj.hasNext()) {
////				Contact abObj=itrObj.next();
////				fileWriter.write(" Name : "+abObj.getContactName()+"\t Number : "+ abObj.getContactNumber());
////				}
//			
//			fileWriter.flush();
//			fileWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void fileOut() {
//		try {
//			File file = new File("phonebook.txt");
//			FileReader fileReader = new FileReader(file);
//			StringBuffer stringBuffer = new StringBuffer();
//			int numCharsRead;
//			char[] charArray = new char[1024];
//			while ((numCharsRead = fileReader.read(charArray)) > 0) {
//				stringBuffer.append(charArray, 0, numCharsRead);
//			}
//			fileReader.close();
//			System.out.println("Contents of file:");
//			System.out.println(stringBuffer.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
