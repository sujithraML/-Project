package multipleinterface;

public class DoubleInterfaceImpl implements InterfaceC{

	@Override
	public void disp() {
		System.out.println("disp method is getting overridden");
	}

	@Override
	public void dis() {
		System.out.println("dis method is getting overridden");
	}

}
