package com.algorithforum.oops;

/**
 * To check which method will call while calling with null.
 * Child signature method will be call i.e method(String str) 
 * @author rajesh.dixit
 *
 */
public class AmbiguityMethodCalling {

	private void method(Object obj) {
		System.out.println("Object method call. ");
	}

	private void method(String str) {
		System.out.println("String method call. ");
	}


	public static void main(String[] args) {
		new AmbiguityMethodCalling().method(null);
	}
}