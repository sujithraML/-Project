package multipleinterface;

public interface InterfaceB {
	void disp();
	default void display (){
		System.out.println("InterfaceB display is getting called");
	}
}
