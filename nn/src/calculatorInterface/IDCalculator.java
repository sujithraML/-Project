package calculatorInterface;

public abstract interface IDCalculator {
	default void dis() {
		System.out.println("IDCALCULATOR");
	}
	 void multiply();
}
