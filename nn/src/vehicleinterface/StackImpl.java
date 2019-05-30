//package vehicleinterface;
//
//import java.util.Scanner;
//
//import calculatorInterface.IDCalculator;
//
//public class StackImpl implements StackInterface {
//	
//
//	private int stack [] =new int [5];
//
//	public static void main(String[] args) {
//		
//		int n=5;
//		
//		StackImpl numberObj=new StackImpl();
//		
//		Object numberObjDisp=new Object();
//		
//		Scanner scannerobj=new Scanner(System.in);
//		
//		try {
//		
//		numberObj.push((Integer)scannerobj.nextInt(),n);
//		n--;
//		}
//		catch(Exception e) {
//			
//		}
//		
//		try {
//			numberObjDisp = numberObj.pop();
//		}
//		catch(Exception e) {
//			throw new EmptyStackException;
//		}
//		
//		try {
//			numberObjDisp = numberObj.peek();
//		}
//		catch(Exception e){
//			throw new EmptyStackException;
//		}
//		
//		System.out.println(numberObjDisp);
//		
//		scannerobj.close();
//	}
//
//	@Override
//	public void push(Object obj,int n) {
//		if (obj instanceof Integer) {
//			numberObj[n]=Integer.parseInt(obj.toString());
//		}
//	}
//
//	@Override
//	public Object pop() {
//		return null;
//	}
//
//	@Override
//	public Object peek() {
//		return null;
//	}
//
//}
