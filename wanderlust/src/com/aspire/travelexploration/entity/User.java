package com.aspire.travelexploration.entity;

public class User {
	private int userId;
	private String emailId;
	private String password;
	private String username;
	private String name;
	private long phone;
	private byte[] profilepic;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userIdValue) {
		if(userIdValue!=0)
			userId = userIdValue;
	}
	public byte[] getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(byte[] profilepicValue) {
		if(profilepicValue!=null)
			profilepic = profilepicValue;
		else
			System.out.println("Not a valid file");
	}
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
		if(passwordValue!=null && passwordValue.length()>=8) {
			if(passwordValue.matches("[A-Za-z0-9]*")) 
				password=passwordValue;
			else 
				System.out.println("Enter valid address");
			}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String usernameValue) {
		if(usernameValue.length()>3) {
			username = usernameValue;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String nameValue) {
		if(nameValue.length()>3) {
			name = nameValue;
		}
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phoneValue) {
		if((int)Math.log10(phoneValue)+1==10) {
			phone = phoneValue;
		}
	}
}
