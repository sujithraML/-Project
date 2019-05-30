package com.aspire.designpatterns.template;

public class PainterChecklist {

	public static void main(String[] args) {
		AbstractPainter painter=new Pro();
		painter.process();
		
		System.out.println("");
		painter=new Beginner();
		painter.process();
	}

}
