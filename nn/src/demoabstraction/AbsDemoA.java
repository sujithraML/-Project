package demoabstraction;

public abstract class AbsDemoA {
	public AbsDemoA(){
	System.out.println("AbsDemoA created "+hashCode());
	}
	public void echo() {
		System.out.println("AbsDemoA echo "+hashCode());
	}
	public static void show() {
		System.out.println("AbsDemoA show");
	}
}
