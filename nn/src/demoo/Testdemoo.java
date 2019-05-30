package demoo;

public class Testdemoo {

	public static void main(String[] args) {
		Shape s1=new Triangle();
		
		System.out.println("Tri  HC"+s1.hashCode());
		s1.height=123;
		s1.width=100;
		s1.draw();
		s1.show();
		s1.printtt();

	}

}
