package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1003 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] one, zero;
		one = new int[41];
		zero = new int[41];

		one[0] = 0;
		zero[0] = 1;

		one[1] = 1;
		zero[1] = 0;

		one[2] = 1;
		zero[2] = 1;
		for (int i = 3; i < 41; i++) {
			one[i] = one[i - 2] + one[i - 1];
			zero[i] = zero[i - 2] + zero[i - 1];
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(zero[N] + " " + one[N]).append("\n");
		}
		System.out.println(sb.toString());

	}

}
