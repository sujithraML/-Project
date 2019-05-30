package com.aspire.classroom.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackImplementation<T> implements StackInterface<T>{
	
	ArrayList <T>arrayList=new ArrayList<T>();

	@Override
	public void push(T objValue) {
	
		arrayList.add(objValue);
		System.out.println("pushed");
	}

	@Override
	public T pop() throws EmptyStackException{
		if(arrayList.size()==0) throw new EmptyStackException();
		System.out.println("popped");
		return arrayList.remove(arrayList.size()-1);
	}

	@Override
	public T peek()throws EmptyStackException {
		if(arrayList.size()==0) throw new EmptyStackException();
		System.out.println("peeked");
		return arrayList.get(arrayList.size()-1);
	}

	
}
