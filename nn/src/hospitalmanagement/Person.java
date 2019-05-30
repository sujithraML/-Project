package hospitalmanagement;

//enum bloodGroup {O+VE,B+VE,A+VE,AB+VE,O-VE,B-VE,A-VE,AB-VE;}
import java.util.Date;

enum Gender {FEMALE,MALE;}

public class Person {
	String personname;
	long personId;
	//bloodGroup typeofBG;
	String contact;
	String address;
	String email;
	Gender type;
	Date dob;
}
