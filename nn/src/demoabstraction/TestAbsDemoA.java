package demoabstraction;

public class TestAbsDemoA {

	public static void main(String[] args) {
		
		
		AbsDemoA.show();// static method can be called without object
		AbsDemoB a=new AbsDemoB();
		a.echo();
	}

}
