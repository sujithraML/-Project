package restaurant;

public class Restaurant {
	private String item;
	private int cost;
	
	public int getCost() {
		if(cost>0)
			return cost;
		else
			System.out.println("Enter valid amount");
			return 0;
	}
	public void setCost(int c) {
		cost=c;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String i) {
		item=i;
	}
	
}



































/*
public void additeminmenu(){
	
}
public void deliteminmenu() {
	
}
public void additeminorder() {
	
}
public void canceliteminorder() {
	
}
*/