package com.aspire.classroom.innerclass;

public class TestCarOuter {

	public static void main(String[] args) {
		CarOuter co1=new CarOuter();
		CarOuter.EngineInner ei1=co1.new EngineInner();
		ei1.printEngine();
		ei1.printEnginee();
		ei1.printEngineee();
	//	ei1.printEngineeee();
		
		System.out.println("\n");
		
		co1.printCar();
		co1.printCarr();
		co1.printCarrr();
	//	co1.printCarrrr();
		
		System.out.println("\n");
		
		CarOuterInherited coi1=new CarOuterInherited();
		CarOuter.EngineInner ei2=coi1.new EngineInner();
		coi1.printCarOuter();
		coi1.printCarOuterr();
		coi1.printCarOuterrr();
	//	coi1.printCarOuterrrr();
		
		System.out.println("\n");
		
		coi1.printCar();
		coi1.printCarr();
		coi1.printCarrr();
	//	coi1.printCarrrr();
		
		System.out.println("\n");
		
		ei2.printEngine();
		ei2.printEnginee();
		ei2.printEngineee();
	//	ei2.printEngineeee();
		
		System.out.println("\n");
		
		CarOuter.EngineStatic.printEngineStatic();
		CarOuter.EngineStatic.printEngineeStatic();
		CarOuter.EngineStatic.printEngineeeStatic();
		//CarOuter.EngineStatic.printEngineeeeStatic();
	}

}
