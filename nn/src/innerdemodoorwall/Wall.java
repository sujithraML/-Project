package innerdemodoorwall;

public class Wall {
	private int height;
	private int width;

	public Wall(int h,int w) {
		this.height=h;
		this.width=w;
	}
	
	public class Door{
	
		private int height;
		private int width;
		
		public Door(int h,int w) {
			height=h;
			width=w;
		}
		
		void open() {
			System.out.println("opened");
		}
		void close() {
			System.out.println("closed");
		}
		void print() {
			
			System.out.println("The height and width of wall is"+Wall.this.height+" "+Wall.this.width);
			System.out.println("The height and width of door is"+height+" "+width);
			
		}
	}
}
