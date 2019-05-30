package multipleinterface;

public interface InterfaceA {
	void disp();
	default void display (){
		System.out.println("InterfaceA display is getting called ");
	}
	default void diss() {
		System.out.println("InterfaceA diss is getting called ");
	}
}
