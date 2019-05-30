package innerdemodoorwall;

import innerdemodoorwall.Wall.Door;

public class TestDoor {
	public static void main(String[] args) {
		Wall wallobj=new Wall(3, 3);
		
		Door doorobj =wallobj.new Door(8,3);
		
		doorobj.open();
		
		doorobj.print();
		
		doorobj.close();
	}
	
}
