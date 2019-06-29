package com.algorithmforum.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		CyclicBarrier cb = new CyclicBarrier(4);

		cb.await();

		System.out.println("Barrier wait has been ended. ");

		MyThread myThread = new MyThread(cb);
		myThread.start();

	}

	private static class MyThread extends Thread {
		private CyclicBarrier cb;

		public MyThread(CyclicBarrier cb) {
			this.cb = cb;
		}

		@Override
		public void run() {

			System.err.println("Thread is running");
		}
	}
}
