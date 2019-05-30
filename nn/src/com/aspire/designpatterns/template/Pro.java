package com.aspire.designpatterns.template;

public class Pro extends AbstractPainter{
	public void scrub() {
		System.out.println("cleaned the wall");
	}
	public void applyPutty() {
		System.out.println("putty applied Evenly");
	}
	public void choosecolor() {
		System.out.println("yelow has been choosen");
	}
	public void paint() {
		System.out.println("applied spl techniques");
	}
	public void waterproof() {
		System.out.println("waterproofing done");
	}
	public void applyStickers() {
		System.out.println("stickers applied");
	}
}
