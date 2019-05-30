package demostatandcon;

public class TestDemoThis {

	public static void main(String[] args) {
		System.out.println("X   "+DemoThis.x);
		
		DemoThis.m2();
		DemoThis d1=new DemoThis();
		d1.m1();
		
		
		System.out.println("Y   "+d1.y);

		d1.y=77777;
		d1.m1();
		//d1.m2();
	}

}
