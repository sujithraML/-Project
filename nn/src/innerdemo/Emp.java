package innerdemo;

public class Emp {
	public final int id;
	public String name;
	int salary;
	private String company="ABCD Ltd";
	
	public Emp() {
		id=1;
	}
	public Emp(int id) {
		int x=100;
		this.salary=x;
		this.id=id;
	}
	public void startWork() {
		
	}
	public class Address{
		public String DoorNo;
		public String StreetName;
		public String City;
		public String Country;
		public String Pincode;
		public void print() {
			System.out.println(DoorNo+ City+Country);
			System.out.println("id = "+Emp.this.id+"salary = "+Emp.this.salary+"Company = "+Emp.this.company);
		}
	}
}
