package accessspecifier2;

import accessspecifier1.ShapeAm;

public class TriangleAm extends ShapeAm{
	
	TriangleAm(){
		super();
		this.height=10;
		this.width=10;
	}
	
	public int height;
	public int width;
	
	
	public void Test() {
	
		
		this.height=100;
		this.width=50;
		super.height=700;
		super.width=600;
		this.show();
		super.show();
		ShapeAm s1=new ShapeAm();
		s1.height=500;
		s1.width=400;
		s1.show();
	}
	public void show() {
		System.out.println("Height: "+height+" Width: "+width);
	}
	public static void main(String [] args) {
		TriangleAm t1=new TriangleAm();
		t1.Test();
	}

}
