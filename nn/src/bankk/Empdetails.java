package bankk;

public class Empdetails {
	private String empName,empAddr,empEmail;
	long empPhoneNo;
	double empId;
	
	public double getEmpId() {
		return empId;
	}
	public void setEmpId(double idValue) {
		if((long)Math.log10(idValue)+1==9)
			empId=idValue;
		else
			System.out.println("Enter valid id. Id must be in 9 digits.");
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String nameValue) {
		if(nameValue!=null) {
			if(nameValue.matches("[A-Za-z]")) {
				if(nameValue.length()>4 && nameValue.length()<15) {
					empName=nameValue;
				}
				else
					System.out.println("Enter valid name");
			}
			else
				System.out.println("Enter valid name");
		}
	}
	
	public String getEmpAddr() {
		return empEmail;
	}
	public void setEmpAddr(String adrValue) {
		if(adrValue!=null) {
			if(empAddr.matches("[A-Za-z0-9,-:]")) 
				empAddr=adrValue;
			else 
				System.out.println("Enter valid address");
			}
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String emailValue) {
		if(emailValue!=null) {
			if(empEmail.contains("@") && empEmail.contains(".com"))
				empEmail=emailValue;
			else
				System.out.println("Enter valid email id");
			}
			else
				return;
	}
	public long getEmpPhoneNo() {
		return empPhoneNo;
	}
	public void setEmpPhoneNo(long phnnoValue) {
		long tempno=phnnoValue;
		if((long)Math.log10(tempno)+1==10)
			empPhoneNo=phnnoValue;
		else
			System.out.println("invalid phone number");
	}
	
}
