package com.designpatterns.singleton;

public class Doubleton {

	private static volatile Doubleton INSTANCE1;
	private static volatile Doubleton INSTANCE2;

	private static int count = 0;

	private Doubleton() {

	}

	public static Doubleton getInstance() {
		if (count++ % 2 == 0) {
			if (INSTANCE1 == null) {

				synchronized (Doubleton.class) {
					if (INSTANCE1 == null) {
						INSTANCE1 = new Doubleton();
					}
				}
			}

			return INSTANCE1;
		} else {
			if (INSTANCE2 == null) {

				synchronized (Doubleton.class) {
					if (INSTANCE2 == null) {
						INSTANCE2 = new Doubleton();
					}
				}
			}
			return INSTANCE2;
		}
	}
}
