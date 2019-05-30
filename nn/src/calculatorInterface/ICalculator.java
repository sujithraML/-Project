package calculatorInterface;

public abstract interface ICalculator {
	void addition(int x,int y);
	void subtraction(int x,int y);
	void multiply(int x,int y);
	void divide(int x,int y);
	default void dis() {
		System.out.println("ICALCULATOR");
	}
	 void add();
}
