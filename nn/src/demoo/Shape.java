package demoo;

public class Shape {
	
	public int height;
	public int width;
	
	protected void printtt() {
		System.out.println("Printed");
	}
	public Shape() {
		System.out.println("c1 shape object is created "+hashCode());
	}
	public Shape(int x) {
		height=x;
		width=x;
		System.out.println("c2 shape object is created");
	}
	public final void draw() {
		System.out.println("Shape.draw:= "+"height "+height+" width "+width);
	}
	public final void draw(int j) {
		System.out.println(j);
	}
	public void show() {
		System.out.println("Shape show"+height+"width"+width);
	}
	public void show(int x) {
		System.out.println("Shape show "+x);
	}
	public void show(double x) {
		System.out.println("Shape show "+x);
	}
}
