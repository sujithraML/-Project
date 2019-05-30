package multipleinterface;

public interface InterfaceC extends InterfaceA,InterfaceB {
	void dis();
	default void display (){
		System.out.println("InterafceC display method is getting called ");
	}
}
