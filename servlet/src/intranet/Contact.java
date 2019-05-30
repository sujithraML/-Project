package intranet;

public class Contact {
	private String emailId;
	private String password;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailIdValue) {
		if(emailIdValue!=null) {
		if(emailIdValue.contains("@") && emailIdValue.contains(".com"))
			emailId=emailIdValue;
		else
			System.out.println("Enter valid email id");
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwordValue) {
		if(passwordValue!=null && passwordValue.length()==8) {
			if(passwordValue.matches("[A-Za-z0-9,-:]*")) 
				password=passwordValue;
			else 
				System.out.println("Enter valid address");
			}
		//password = passwordValue;
	}
	
}
