package phoneinterface;

public class Galaxy implements Mphone{
	public void sendMessage(){
		System.out.println("msg has been sent");
	}
	public void recieveMessage() {
		System.out.println("Message has been recieved");
	}
	public void makeACall() {
		System.out.println("Call initiated successfully");
	}
	public void recieveCall() {
		System.out.println("Call recieved successfully");
	}
	public static void main(String[] args) {
		Galaxy g1=new Galaxy();
		Object g2=new Galaxy();
		//if(g1 instanceof Galaxy) {
			g1.sendMessage();
			g1.recieveMessage();
			g1.makeACall();
			g1.recieveCall();
		//}
	
		if(g2 instanceof Mphone) {
			Mphone g3=(Mphone)g2;
			g3.sendMessage();
			g3.recieveMessage();
			g3.makeACall();
			g3.recieveCall();
		}
	}

}
