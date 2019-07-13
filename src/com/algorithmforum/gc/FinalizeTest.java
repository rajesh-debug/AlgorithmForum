package com.algorithmforum.gc;

public class FinalizeTest {

	public static void main(String[] args) {
		Object o = new Object();
		while (true) {
			o = new Object();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize commented.");
	}
}
