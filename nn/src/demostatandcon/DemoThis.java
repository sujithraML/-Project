package demostatandcon;

public class DemoThis {
		static int x=123;
		int y=0;
		
		public void m1() {
			System.out.println(" X "+ DemoThis.x);
			System.out.println(" Y "+ this.y);
			
			DemoThis d2=new DemoThis();
			System.out.println("  Y "+this.y);
			y=55555;
			d2.y=66666;
			//System.out.println("  X "+ this.x);
			//System.out.println("  X "+ d2.x);
			d2.m3();
		}
		public static void m2() {
			System.out.println("   X "+DemoThis.x);
			DemoThis d2=new DemoThis();
			System.out.println("   Y "+d2.y);
			
			d2.y=66666;
			System.out.println("    Y "+d2.y);
		}
		public void m3() {
			System.out.println("Y t "+this.y);
			DemoThis d2=new DemoThis();
			System.out.println("Y t  "+d2.y);
			
			y=44444;
			d2.y=33333;
			System.out.println("Y t   "+this.y);
			System.out.println("Y t    "+d2.y);
		}
}
