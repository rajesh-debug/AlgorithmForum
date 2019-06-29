package com.algorithmforum.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class CallableThread implements Callable<Integer> {
	@Override
	public Integer call() {
		int cnt = 1;
		for (; cnt < 3; cnt++) {
			System.out.println("Callable:" + cnt);
		}
		return cnt;
	}
}

class RunnableThread implements Runnable {
	@Override
	public void run() {
		int cnt = 1;
		for (; cnt < 3; cnt++) {
			System.out.println("Runnable:" + cnt);
		}
	}
}

public class NewFixedThreadPoolDemoOne {
	public static void main(final String... args) throws InterruptedException, ExecutionException {
		final int noOfTh = 2;
		// creates fixed thread pool
		final ExecutorService exService = Executors.newFixedThreadPool(noOfTh);
		// runnable thread start to execute. "done" will be returned after successful
		// thread run
		final Future<String> runFuture = exService.submit(new RunnableThread(), "done");
		// gets value for Runnable thread
		final String runval = runFuture.get();
		System.out.println("Task:" + runval);
		// callable thread starts to execute
		final Future<Integer> callFuture = exService.submit(new CallableThread());
		// gets value of callable thread
		final int callval = callFuture.get();
		System.out.println("Return Value:" + callval);
		// checks for thread termination
		final boolean isTerminated = exService.isTerminated();
		System.out.println(isTerminated);
		// waits for termination for 30 seconds only
		exService.awaitTermination(30, TimeUnit.SECONDS);
		exService.shutdown();
	}
}