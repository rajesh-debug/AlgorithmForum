package com.algorithmforum.thread;

class ShutDownHook extends Thread {
	public void run() {
		System.out.println("cleanup.. shut down hook task");
	}
}

public class TestShutDownHook {
	public static void main(String[] args) throws Exception {

		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new ShutDownHook());

		System.out.println("Now main sleeping.press ctrl+c to exit");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
		}
	}
}
