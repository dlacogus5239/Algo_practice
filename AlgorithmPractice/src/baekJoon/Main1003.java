package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1003 {
	static int N;
	static int[] ONE = new int[41];
	static int[] ZERO = new int[41];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		ONE[0] = 0;
		ZERO[0] = 1;

		ONE[1] = 1;
		ZERO[1] = 0;

		ONE[2] = 1;
		ZERO[2] = 1;

		for (int i = 3; i <= 40; i++) {
			ONE[i] = ONE[i - 2] + ONE[i - 1];
			ZERO[i] = ZERO[i - 2] + ZERO[i - 1];
		}

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append(ZERO[N] + " " + ONE[N]).append("\n");

		}

		System.out.println(sb.toString());

	}

}
