package restaurant;

import java.util.Scanner;

public class Custmr {
	public static void main(String args[]) {
		Restaurant r=new Restaurant();
		
		System.out.println("Enter the item you want : ");
		Scanner s=new Scanner(System.in);
		String i=s.next();
		
		r.setItem(i);
		String itemchoosen=r.getItem();
		
		System.out.println("Enter the amount to be paid : ");
		Scanner t=new Scanner(System.in);
		int c=t.nextInt();
		
		System.out.println("The item ordered is : "+itemchoosen);
		
		r.setCost(c);
		int cost=r.getCost();
		
		System.out.println("Amount paid for the item is "+cost);
		
		s.close();
		t.close();
	
	}
}











/*
System.out.println("Enter your name");
String customername=t.next();

System.out.println("Enter your contact no");
Long customerno=t.nextLong();

System.out.println("Enter your city,mailid");
String customerdetails=t.next();

if(customerdetails.contains("@") && customerdetails.contains(".com"))
{
	System.out.println("Thank you");
	
	System.out.println("The customer and details are"+customername+"\n"+customerno+"\n"+customerdetails);
}
else
{
	customerdetails="\0";
	System.out.println("Enter valid email id");
}
*/