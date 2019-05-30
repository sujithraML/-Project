package com.aspire.classroom.innerclass;

public class CarOuter {
	public String brand;
	public int modelNo;
	
	public void printCar() {
		System.out.println("public printCar");
	}
	protected void printCarr() {
		System.out.println("protected printCar");
	}
	void printCarrr() {
		System.out.println("default printCar");
	}
	private void printCarrrr() {
		System.out.println("public printCar");
	}
	public static class EngineStatic{
		public static void printEngineStatic() {
			System.out.println("public static printEngine ");
		}
		protected static void printEngineeStatic() {
			System.out.println("protected static printEngine");
		}
		static void printEngineeeStatic() {
			System.out.println("default static printEngine");
		}
		private static void printEngineeeeStatic() {
			System.out.println("private static printEngine");
		}
	}
	public class EngineInner{
		public int modelNo;
		public String engineType;
		
		public void printEngine() {
			System.out.println("public printEngine");
		}
//		public static void testSatic() {
//			System.out.println("Static");
//		}
		protected void printEnginee() {
			System.out.println("protected printEngine");
		}
		void printEngineee() {
			System.out.println("default printEngine");
		}
		private void printEngineeee() {
			System.out.println("public printEngine");
		}
	}
}
