package intranet;
enum status{CURRENT,DISCONTINUED;}
enum type{FRIEND,COLLEAGUE,FAMILY}
public class PersonalContact {
	int contactid;
	String name;
	String email;
	String city;
	String companyname;
	type type;
	status statusOfContact;
	long number;
	public long getNumber() {
		return number;
	}
	public void setNumber(long numberValue) {
		if((int)Math.log10(numberValue)+1==10) {
			number = numberValue;
		}
	}
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactidValue) {
		if((int)Math.log10(contactidValue)+1==4) {
			contactid = contactidValue;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String emailValue) {
		if(emailValue.contains("@")&& emailValue.contains(".com")) {
			email = emailValue;
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String cityValue) {
		if(cityValue!=null & cityValue.length()>3) {
			city = cityValue;
		}
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companynameValue) {
		if(companynameValue!=null & companynameValue.length()>3) {
			companyname = companynameValue;
		}
	}
	public type getType() {
		return type;
	}
	public void setType(type typeValue) {
			type = typeValue;
	}
	public status getStatusOfContact() {
		return statusOfContact;
	}
	public void setStatusOfContact(status statusOfContactValue) {
		statusOfContact = statusOfContactValue;
	}
}
