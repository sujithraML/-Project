package demoo;

public class Triangle extends Shape{
	public Triangle() {
		System.out.println("c1 Traingle object is created "+hashCode());
	}
	public Triangle(int y){
		System.out.println("c2 Triangleobject is created "+hashCode());
	}
	public void show() {
		System.out.println("Traingle show");
	}

	
}

