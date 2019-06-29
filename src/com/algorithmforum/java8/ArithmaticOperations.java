package com.algorithmforum.java8;

/**
 * This is the functional interface with unimplemented method to check number is
 * even.
 * 
 * @author rajesh.dixit
 */
interface ArithmaticOper {
	int operation(int num1, int num2);
}

/**
 * This is test class which check
 */
public class ArithmaticOperations {

	public static void main(String[] args) {

		// Lambda expression to add two numbers.
		ArithmaticOper arithmatic = (num1, num2) -> (num1 + num2);
		System.out.println("Addition is: " + arithmatic.operation(4, 5));

		// Lambda expression to subtraction.
		arithmatic = (num1, num2) -> (num1 - num2);
		System.out.println("Subtraction is: " + arithmatic.operation(10, 5));

		// Lambda expression to multiply two numbers.
		arithmatic = (num1, num2) -> (num1 * num2);
		System.out.println("Muliplication is " + arithmatic.operation(10, 5));
	}
}
