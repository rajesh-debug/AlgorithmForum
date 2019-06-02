package com.algorithmforum.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String args[]) {
		// Get ExecutorService from Executors utility class, thread pool size is 10
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		// Create a list to hold the Future object associated with Callable
		List<Future<String>> futureList = new ArrayList<Future<String>>();

		/**
		 * Create MyCallable instance using Lambda expression which return
		 * the thread name executing this callable task
		 */
		Callable<String> callable = () -> {
			Thread.sleep(2000);
			return Thread.currentThread().getName();
		};
		
		/**
		 * Submit Callable tasks to be executed by thread pool
		 * Add Future to the list, we can get return value using Future
		 **/
		for (int i = 0; i < 20; i++) {
			Future<String> future = executor.submit(callable);
			futureList.add(future);
		}
		
		/**
		 * Print the return value of Future, notice the output delay
		 * in console because Future.get() waits for task to get completed
		 **/
		for (Future<String> future : futureList) {
			try {
				System.out.println(new Date() + " | " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service.
		executor.shutdown();
	}
}
