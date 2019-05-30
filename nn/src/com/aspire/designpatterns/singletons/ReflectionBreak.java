package com.aspire.designpatterns.singletons;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionBreak {
	public static void main(String[] args) {
		EagerInitialization one = EagerInitialization.getInstance();
		EagerInitialization two = null;
		
		try {
			
			/* changes the access level of private field and sets it to null*/
			
			Field object = EagerInitialization.class.getDeclaredField("object");
			object.setAccessible(true);
			object.set(object, null);
			
			/*changes the access level of constructor from private to public */
			
			Constructor<EagerInitialization> constructor = EagerInitialization.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			
			two = (EagerInitialization) constructor.newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Object one : "+one.hashCode()+"\n"+"Object two : "+two.hashCode());
	}
}
