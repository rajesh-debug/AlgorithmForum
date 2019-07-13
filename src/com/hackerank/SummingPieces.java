package com.hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Dynamic programming | Summing pieces
 * 
 * @author rajesh.dixit
 *
 */
public class SummingPieces {

	/*
	 * Complete the summingPieces function below.
	 */
	static int summingPieces(int[] arr) {

		int sum = 0;

		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arrCount = Integer.parseInt(scanner.nextLine().trim());

		int[] arr = new int[arrCount];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int arrItr = 0; arrItr < arrCount; arrItr++) {
			int arrItem = Integer.parseInt(arrItems[arrItr].trim());
			arr[arrItr] = arrItem;
		}

		int result = summingPieces(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
