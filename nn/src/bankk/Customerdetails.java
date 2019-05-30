package bankk;

import java.util.Calendar;
import java.util.Date;

enum TypeOfAccount {SAVINGS,CURRENT;}

public class Customerdetails {
	private long customerId;
	private String customerName,address,email,panNo;
	private long phoneNo,accountNo,balance,branchId;
	private Date dob;
	TypeOfAccount accType;
	
	public long getId() {
		return customerId;
	}
	public void setId(long idValue) {
		if((long)Math.log10(idValue)+1==9)
			customerId=idValue;
		else
			System.out.println("Enter valid id. Id must be in 9 digits.");
	}
	
	public String getName() {
		return customerName;
	}
	public void setName(String nameValue) {
		if(nameValue!=null) {
			if(customerName.matches("[A-Za-z]")) {
				if(customerName.length()>4 && customerName.length()<15) {
					customerName=nameValue;
				}
				else
					System.out.println("Enter valid name");
			}
			else
				System.out.println("Enter valid name");
		}
	}
	
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panValue) {
		if(panValue!=null) {
		if(panNo.length()!=8)
			System.out.println("Enter valid pan number");
		else
			panNo=panValue;
		}
		else
			return;
	}
	
	public String getAddr() {
			return address;
	}
	public void setAddr(String adrValue) {
		if(adrValue!=null) {
		if(customerName.matches("[A-Za-z0-9,-:]")) 
			address=adrValue;
		else 
			System.out.println("Enter valid address");
		}
	}
	public TypeOfAccount getType() {
			return accType;
	}
	public void setType(TypeOfAccount typeValue) {
			accType=typeValue;
	}
	
	public long getPhoneNo() {
			return phoneNo;		
	}
	public void setPhoneNo(long noValue) {
		long tempno=phoneNo;
		if((long)Math.log10(tempno)+1==10)
			phoneNo=noValue;
		else
			System.out.println("invalid phone number");
	}
	
	public String getEmail() {
			return email;
	}
	public void setEmail(String emailValue) {
		if(emailValue!=null) {
		if(email.contains("@") && email.contains(".com"))
			email=emailValue;
		else
			System.out.println("Enter valid email id");
		}
		else
			return;
	}
	public long getAccNo() {
		return accountNo;
	}
	public void setAccNo(long acValue) {
		if((long)Math.log10(accountNo)+1!=15)
			System.out.println("Enter valid account no");
		else
			accountNo=acValue;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date DateValue) {
		//calendar object for date
		Calendar calbirthday=Calendar.getInstance();
		calbirthday.setTimeInMillis(DateValue.getTime());
		
		long currentTime=System.currentTimeMillis();
		Calendar now=Calendar.getInstance();
		now.setTimeInMillis(currentTime);
		
		int year=now.get(Calendar.YEAR)- calbirthday.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)- calbirthday.get(Calendar.MONTH);
		 if(month<0) {
			 year-=1;
		 }
		 if(year<18) {
			 System.out.println("You are not eligble or Enter valid date");
		 }
		 else
			 dob=DateValue;
	}
	public long getBalance() {
			return balance;		
	}
	public void setBalance(long balValue) {
		long tt=balValue;
		if((long)Math.log10(tt)+1>0)
			balance=tt;
		else
			System.out.println("invalid balance");
	}
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long idValue) {
		if((long)Math.log10(idValue)+1==6)
			branchId=idValue;
		System.out.println("Enter valid id");
	}
}
