package bankk;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TestCustomerEmployeeABC {
	public static void main(String args[]) {
		
		for(int j=0;j<2;j++) {
		
		for(int i=0;i<3;i++) {
		
		System.out.println("Enter \n 1 if you are a customer \n 2 if you are an employee");
		
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		if(choice==1) {
		Customerdetails customerDetails=new Customerdetails();
		
		System.out.println(" Enter your id : ");
		Scanner s=new Scanner(System.in);
		long id=s.nextLong();
		
		customerDetails.setId(id);
		long customerId=customerDetails.getId();
		if(customerId==0) {
			break;
		}
		System.out.println("Enter your name : ");
		
		String name=s.next();
		
		customerDetails.setName(name);
		String customerName=customerDetails.getName();
		
		if(customerName==null) {
			break;
		}
		
		System.out.println("Enter which type of account you want \n 1.Savings account \n 2.Current account");
		
		customerDetails.setType(TypeOfAccount.valueOf(s.next().toUpperCase()));
		
		TypeOfAccount t1=customerDetails.getType();
		
		System.out.println("The chosen account type is : "+t1);
		
		System.out.println("Enter your address : ");
		
		String adr=s.next();
		
		customerDetails.setAddr(adr);
		String addr=customerDetails.getAddr();
		
		if(addr==null) {
			break;
		}
		System.out.println("Enter your email : ");
		
		String em=s.next();
		
		customerDetails.setName(em);
		String email=customerDetails.getEmail();
		
		if(email==null) {
			break;
		}
		
		System.out.println("Enter your contact no : ");
		
		long phno=s.nextLong();
		
		customerDetails.setPhoneNo(phno);
		long phoneNo=customerDetails.getPhoneNo();
		
		if(phoneNo==0) {
			break;
		}
		
		System.out.println("Enter your account no : ");
		
		long accno=s.nextLong();
		
		customerDetails.setAccNo(accno);
		long accountNo=customerDetails.getAccNo();
		
		if(accountNo==0) {
			break;
		}
		
		System.out.println("Enter your dob : ");
	
		String dateString=s.next();
		int year=Integer.parseInt(dateString.substring(0, 4));
		int month=Integer.parseInt(dateString.substring(5, 7));
		int day=Integer.parseInt(dateString.substring(8, 10));
		
		Calendar date=new GregorianCalendar(year,month,day);
		//customerDetails.setDob(date);
		Date dateOfBirth=customerDetails.getDob();
		
		System.out.println("The customer Id is : "+customerId);
		
		System.out.println("The customer name is : "+customerName);

		System.out.println("The customer Address is : "+addr);

		System.out.println("The customer email is : "+email);

		System.out.println("The customer phone no is : "+phoneNo);

		System.out.println("The customer account no is : "+accountNo);
		
		s.close();
		}
		else {
				Empdetails empDetails=new Empdetails();
				
				System.out.println(" Enter your id : ");
				Scanner y=new Scanner(System.in);
				
				empDetails.setEmpId(y.nextDouble());
				double empId=empDetails.getEmpId();
				
				if(empId==0) {
					break;
				}
				
				System.out.println("Enter your name : ");
				
				empDetails.setEmpName(y.next());
				String empName=empDetails.getEmpName();
				
				if(empName==null) {
					break;
				}
				
				System.out.println("Enter your address : ");
				
				empDetails.setEmpAddr(y.next());
				String empAddr=empDetails.getEmpAddr();
				
				if(empAddr==null) {
					break;
				}
				
				System.out.println("Enter your email : ");
				
				empDetails.setEmpEmail(y.next());
				String empEmail=empDetails.getEmpEmail();
				
				if(empEmail==null) {
					break;
				}
				
				System.out.println("Enter your contact no : ");
				
				empDetails.setEmpPhoneNo(y.nextLong());
				long empPhoneNo=empDetails.getEmpPhoneNo();
				
				if(empPhoneNo==0) {
					break;
				}
				
				System.out.println("The customer Id is : "+empId);
				
				System.out.println("The customer name is : "+empName);
	
				System.out.println("The customer Address is : "+empAddr);
	
				System.out.println("The customer email is : "+empEmail);
	
				System.out.println("The customer phone no is : "+empPhoneNo);
			
			y.close();
			
		}
		scanner.close();
		}
		}
	
	}
}
