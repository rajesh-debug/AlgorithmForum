package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/maximize-the-earning-137963bc-323025a6/description/
 * 
 * @author rajesh.dixit
 *
 */
public class MaximizeEarning {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = null;
		try {
			scan = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder output = new StringBuilder();
			int T = Integer.valueOf(scan.readLine());
			for (int i = 0; i < T; i++) {
				String[] nc = scan.readLine().split(" ");
				int n = Integer.valueOf(nc[0]);
				int c = Integer.valueOf(nc[1]);
				int f = -1;
				int count = 0;
				String[] heights = scan.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					int h = Integer.valueOf(heights[j]);
					if (f < h) {
						f = h;
						count++;
					}
				}
				output.append((c * count) + "\n");
			}
			System.out.println(output.toString());
		} finally {
			scan.close();
		}
	}
}
