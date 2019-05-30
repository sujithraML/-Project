package com.aspire.classroom.assignments;

import java.util.Scanner;

public class TestPhoneBookList {

	public static void main(String[] args) {
		
		PhoneBookList phoneBookObj=new PhoneBookList();
		Scanner scannerObj=new Scanner(System.in);
		for(int j=0;j<10;j++) {
			System.out.println("Enter the number of your choice 1.add  2.search  3.update  4.remove  5.display 6.save into file 7.save into sql 8.exit");
			int choice=scannerObj.nextInt();
			switch(choice) {
			case 1:
				phoneBookObj.beforeAdd();
				System.out.println("Enter the Number of Contacts you want to enter");
				int n=scannerObj.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter the contact name and number");
					String name=scannerObj.next();
					phoneBookObj.add(name,scannerObj.nextLong());
				}
				break;
			case 2:
				System.out.println("Enter the contact name and number you want to search");
				phoneBookObj.search(scannerObj.next(),scannerObj.nextLong());
				break;
			case 3:
				System.out.println("Enter the contact number you want to update");
				long existNum=scannerObj.nextLong();
				System.out.println("Do you want to update the 1.number 2.name");
				int opt=scannerObj.nextInt();
				if(opt==1) {
					long newNum=scannerObj.nextLong();
					phoneBookObj.update(existNum,newNum,null);
				}
				if(opt==2)
				break;
			case 4:
				System.out.println("Enter the contact name and number you want to delete");
				phoneBookObj.remove(scannerObj.next(),scannerObj.nextLong());
				break;
			case 5:
				phoneBookObj.display();
				break;
			case 6:
				phoneBookObj.fileInto();
				break;
			case 7:
				phoneBookObj.jdbcInto();
				break;
			case 8:
				System.exit(0);
			}
	
		}
	}

}
