package innerdemo;

public class TestEmp {

	public static void main(String[] args) {
		
		Emp e1=new Emp(10);
		
		Emp.Address add =e1.new Address();
		
		add.City="Madurai";
		add.Country="India";
		add.DoorNo="123456";
		add.print();
		e1.startWork();
		e1=null;
		System.out.println("After=null");
		add.print();
		Runtime rt=Runtime.getRuntime();
		rt.gc();
		System.out.println("After GC");
		add.print();

	}

}
