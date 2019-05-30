package com.aspire.classroom.stack;

import java.util.EmptyStackException;

public interface StackInterface<T> {
	void push(T obj);
	Object pop() throws EmptyStackException;
	Object peek() throws EmptyStackException;
}
