package com.aspire.classroom.assignments;

import java.util.Scanner;

public class TestPhoneBookSet {

	public static void main(String[] args) {
		PhoneBookList phoneBookObj=new PhoneBookList();
		for(int j=0;j<10;j++) {
			Scanner scannerObj=new Scanner(System.in);
			
			System.out.println("Enter the number of your choice 1.add  2.search  3.update  4.remove  5.display");
			int choice=scannerObj.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the Number of Contacts you want to enter");
				int n=scannerObj.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter the contact name and number");
					phoneBookObj.add(scannerObj.next(),scannerObj.nextLong());
				}
				break;
			case 2:
				System.out.println("Enter the contact name and number you want to search");
				phoneBookObj.search(scannerObj.next(),scannerObj.nextLong());
				break;
			case 3:
				System.out.println("Enter the contact number you want to update");
				phoneBookObj.update(scannerObj.nextLong(),scannerObj.nextLong(),scannerObj.next());
				break;
			case 4:
				System.out.println("Enter the contact name and number you want to delete");
				phoneBookObj.remove(scannerObj.next(),scannerObj.nextLong());
				break;
			case 5:
				phoneBookObj.display();
				break;
				
			}
	
		}
	}

}
