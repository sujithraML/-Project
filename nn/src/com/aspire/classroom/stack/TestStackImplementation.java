package com.aspire.classroom.stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class TestStackImplementation {

	public static void main(String[] args) 
	{
		Scanner scannerobj=new Scanner(System.in);
		StackImplementation<Integer> numberObj=new StackImplementation<Integer>();
		Integer numberObjDisp=null;

		try 
		{
			numberObjDisp = numberObj.peek();
			System.out.println(numberObjDisp);
			numberObjDisp = numberObj.pop();
			System.out.println(numberObjDisp);
		}
		catch(EmptyStackException err)
		{
		  System.out.println(err.getMessage()+" "+err.getClass().getName());
		}

		
		for(int i=0;i<10;i++) {
			System.out.println("Enter the element to be pushed");
			try 
			{
				numberObj.push((Integer)scannerobj.nextInt());
			}finally 
			{
				scannerobj.close();
			}
		}
		
		for(int i=0;i<10;i++) {
			try 
			{
				numberObjDisp = numberObj.peek();
				System.out.println(numberObjDisp);
				numberObjDisp = numberObj.pop();
				System.out.println(numberObjDisp);
			}
			catch(EmptyStackException err)
			{
			  System.out.println(err.getMessage());
			}
		}
	}

}
