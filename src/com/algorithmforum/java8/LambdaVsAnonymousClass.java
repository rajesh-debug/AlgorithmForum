package com.algorithmforum.java8;

interface Calculate {
	int multiply(int a, int b);
}

public class LambdaVsAnonymousClass {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		Calculate calculate = new Calculate() {
			@Override
			public int multiply(int a, int b) {
				return a * b;
			}
		};
		
		for (int i = 0; i < 100000; i++) {
			calculate.multiply(3, 4);
		}

		long executionTime = System.nanoTime() - startTime;
		System.out.println("Execution time using anonymous " + executionTime);

		startTime = System.nanoTime();
		Calculate calculate1 = (int a, int b) -> {
			return a * b;
		};
		for (int i = 0; i < 100000; i++) {
			calculate1.multiply(3, 4);
		}
		executionTime = System.nanoTime() - startTime;
		System.out.println("Execution time using lambda " + executionTime);
	}
}
