package com.algorithmforum.java8;

/**
 * This is the functional interface with unimplemented method to check number is
 * even.
 * 
 * @author rajesh.dixit
 */
interface Arithmatic {
	boolean isNumberIsEven(int num);

}

/**
 * This is test class to check number is even
 */
public class CheckNumberIsEven2 {

	public static void main(String[] args) {

		// Lambda expression based implementation to check number is even.
		Arithmatic arithmatic = (num) -> (num % 2 == 0);

		System.out.println(arithmatic.isNumberIsEven(4));
	}
}
