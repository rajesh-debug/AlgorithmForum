package com.algorithmforum.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NPrimesInJava {

	/**
	 * Sieve of Eratosthenes
	 * 
	 * @param n
	 * @return list of n prime numbers.
	 */
	private static List<Integer> getNPrimesUsingSieve(int n) {
		boolean[] array = new boolean[n * n + 1];
		Arrays.fill(array, true);
		
		List<Integer> list = new ArrayList<>();

		int i = 2;
		
		// exit from loop is the n number has been generated.
		while (list.size() < n) {
			int j = 2;
			
			while (array[i] && i * j < array.length - 1) {
				array[i * j] = false;
				j++;
			}
			
			if (array[i]) {
				list.add(i);
			}
			i++;
		}

		return list;
	}

	/**
	 * Why is every prime no of the form 6k+1 or 6k-1?
	 * 
	 * It is because every third number is divisible by 3 and every second number is
	 * divisible by 2. Suppose a number, say 17, than 15 16 17 18 19 ...... now you can
	 * see number below and above it are divisible by 2, and either of it has to be
	 * a multiple of 3, so this formula holds !
	 * 
	 * @param n
	 * @return list of n prime numbers.
	 */
	private static List<Integer> getNPrimes(int n) {

		List<Integer> primeList = new LinkedList<>(Arrays.asList(2, 3));

		int i = 1;
		while (primeList.size() < n) {
			int prime1 = 6 * i - 1;
			int prime2 = 6 * i + 1;
			
			if (isPrime(prime1)) {
				primeList.add(prime1);
			}

			if (isPrime(prime2)) {
				primeList.add(prime2);
			}
			i++;
		}
		return primeList;
	}

	/**
	 * To check that a number is prime or not.
	 * 
	 * @param prime
	 * @return return boolean for number is prime or not.
	 */
	private static boolean isPrime(int prime) {
		for (int i = 2; i * i <= prime; i++) {
			if (prime % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)) {
			
			System.out.println("Enter the number: ");
			int n = scan.nextInt();
			List<Integer> primeList = getNPrimes(n);
			System.out.println(primeList);

			primeList = getNPrimesUsingSieve(n);
			System.out.println(primeList);
		}
	}
}
