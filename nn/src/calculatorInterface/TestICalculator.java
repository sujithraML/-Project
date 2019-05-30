package calculatorInterface;

public class TestICalculator extends Difff implements IDCalculator,ICalculator{
	

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
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void multiply() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Diff t1=new Diff();
		t1.dis();	
	}
	
}