package com.aspire.designpatterns.factory;

public class StationeryFactory {
	public static Flair getObject(String type, String brand) {
		switch(brand.toLowerCase()) {
		case "flair":
			switch(type.toUpperCase()) {
			case "PENCIL":
				return new FlairPencil();
			case "PEN":
				return new FlairPen();
			case "SKETCH":
				return new FlairSketch();
			}
		case "Faber-Castell":
			System.out.println("stock unavailable");
			return null;
		default:
			System.out.println("no such products");
		}
		return null;
	}
}
