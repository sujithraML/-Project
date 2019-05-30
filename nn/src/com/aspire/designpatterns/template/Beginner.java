package com.aspire.designpatterns.template;

public class Beginner extends AbstractPainter{
	public void scrub() {
		System.out.println("cleaned the wall");
	}
	public void applyPutty() {
		System.out.println("putty applied");
	}
	public void choosecolor() {
		System.out.println("yelow has been choosen");
	}
	public void paint() {
		System.out.println("painting done");
	}
	public void waterproof() {
		System.out.println("waterproofing done");
	}
	public void applyStickers() {
		System.out.println("stickers applied");
	}
}
