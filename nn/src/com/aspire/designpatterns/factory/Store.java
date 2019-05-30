package com.aspire.designpatterns.factory;

import java.util.Scanner;

public class Store {

	public static void main(String[] args) {
		System.out.println("Enter the [brand type] of the required product: ");
		Scanner scanner=new Scanner(System.in);
		String brand=scanner.next();
		String type=scanner.next();
		Stationery stationery=new Stationery();
		Flair flair=stationery.getObject(type, brand);
		flair.write();
		scanner.close();
	}
}
