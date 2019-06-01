package com.algorithmforum.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortOnlyNonPrimeNumbers {

	private static final boolean[] PRIMES = new boolean[1000];

	/** Sieve of eratosthenes. */
	static {
		int n = (int) Math.sqrt(PRIMES.length);

		Arrays.fill(PRIMES, true);

		for (int i = 2; i < n; i++) {
			if (PRIMES[i]) {
				for (int j = 2; i * j < PRIMES.length; j++) {
					PRIMES[i * j] = false;
				}
			}
		}
	}

	private static void sortNumbers(int[] arr) {
		List<Integer> extractedPrimes = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (PRIMES[arr[i]]) {
				extractedPrimes.add(arr[i]);
			}
		}

		Collections.sort(extractedPrimes);

		for (int i = 0; i < arr.length; i++) {
			if (PRIMES[arr[i]]) {
				arr[i] = extractedPrimes.get(0);
				extractedPrimes.remove(0);
			}
		}
	}

	/**
	 * Print the array using the java 8 streams.
	 * 
	 * @param arr
	 */
	private static void printArray(int[] arr) {
		System.err.println("Arrays elements are: ");
		Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

	}

	public static void main(String[] args) {

		int[] arr = { 100, 11, 500, 2, 17, 1 };

		sortNumbers(arr);

		printArray(arr);
	}
}
