package hackerearth;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GlowingBulbs {

	public static void main(String[] args) {

		List<Integer> primes = new LinkedList<>();
		try (Scanner scan = new Scanner(System.in)) {

			int t = scan.nextInt();

			for (int i = 0; i < t; i++) {
				char[] switches = scan.next().toCharArray();
				for (int j = 0; j < switches.length; j++) {
					if (switches[j] == '1') {
						primes.add(j + 1);
					}
				}
				long k = Long.valueOf(scan.next());
				int bulbIdx = findKthGlowingBulb(switches, k);

				System.out.println(bulbIdx);
			}
		}
	}

	// 0 1 1 0 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 1 0 0
	// 0

	private static int findKthGlowingBulb(char[] switches, long k) {
		boolean[] array = new boolean[/*40 * k*/40];

		for (int l = 0; l < 40; l++) {
			if (switches[l] == '1') {
				for (int i = 1; (l + 1) * i < array.length; i++) {
					array[(l + 1) * i] = true;
				}
			}
		}
		int count = 0;
		for (int i = 1; i < array.length; i++) {
			boolean v = array[i];
			if (v) {
				count++;
			}

			if (count == k) {
				return i;
			}
		}
		return -1;
	}
}
