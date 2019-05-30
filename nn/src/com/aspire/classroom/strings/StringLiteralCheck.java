package com.aspire.classroom.strings;

public class StringLiteralCheck {
	public static void main(String[] args) {
		String s1=new String("Sheldon Cooper");
		String s2=new String("Harrison Wells");
		String s3=new String("Sheldon Cooper");
		String s4="Sheldon Cooper";
		System.out.println(s1.hashCode()+"\t"+s2.hashCode()+"\t"+s3.hashCode()+"\t"+s4.hashCode()+"\t");
		System.out.println(s1==s3);
	}
}
