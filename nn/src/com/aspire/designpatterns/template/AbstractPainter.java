package com.aspire.designpatterns.template;

public abstract class AbstractPainter {
	public abstract void scrub();
	public abstract void applyPutty();
	public abstract void choosecolor() ;
	public abstract void paint();
	public abstract void waterproof();
	public abstract void applyStickers();
	
	public void process() {
		scrub();
		applyPutty();
		choosecolor() ;
		paint();
		waterproof();
		applyStickers();
	}
}
