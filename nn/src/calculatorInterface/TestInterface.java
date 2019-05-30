package calculatorInterface;

public class TestInterface implements ICalculator,IDCalculator{
	
	public void show1() {
		ICalculator.super.dis();
	}
	public void show2() {
		IDCalculator.super.dis();
	}

	
	public void dis(ICalculator obj) {
		if(obj instanceof ICalculator)
			ICalculator.super.dis();
	
	}
	public void dis(IDCalculator obj) {
		if (obj instanceof IDCalculator)
			IDCalculator.super.dis();
	}
@Override
	public void dis() {
		ICalculator.super.dis();
	}
		public void dis1() {
		IDCalculator.super.dis();
	}
	public static void main(String[] args) {
		TestInterface t1=new TestInterface();
		
		IDCalculator c2=(IDCalculator)t1;
		c2.multiply();
		
		ICalculator c1=(ICalculator)t1;
		c1.add();
		
		t1.dis1();

	}
	@Override
	public void multiply() {
		System.out.println("Multiply");
	}
	@Override
	public void add() {
		System.out.println("Add");
	}
	@Override
	public void addition(int x, int y) {
		System.out.println(x+y);
	}
	@Override
	public void subtraction(int x, int y) {
		System.out.println(x-y);
	}
	@Override
	public void multiply(int x, int y) {
		System.out.println(x*y);
	}
	@Override
	public void divide(int x, int y) {
		System.out.println(x/y);
	}

}
