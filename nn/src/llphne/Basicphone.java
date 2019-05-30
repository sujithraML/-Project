package llphne;

public class Basicphone {
	long modelno;
	String manufacturer,color,modelname,height,width,screensize,weight;
	int[][] keypad= {{'1','2','3','4','5','6','7','8','9','*','0','#'}};
	public void makecall(long v){
		System.out.println("calling..."+v);	
	}
	public  void recievecall() {
		Long n=getno();
		System.out.println(n);
	}
	 long getno() {
		Long l=478236812l;
		return l;
	}
	void redial(long savedno) {
		System.out.println("redialing...");
		makecall(savedno);
	}
}
