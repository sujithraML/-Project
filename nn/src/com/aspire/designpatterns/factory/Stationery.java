package com.aspire.designpatterns.factory;

public class Stationery {
	
	Stationery(){
		
	}
	public Flair getObject(String type, String brand) {
		return StationeryFactory.getObject(type,brand);
	}
}
