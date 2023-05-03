package baekJoon;

import java.io.IOException;
import java.util.Scanner;

public class Main9461 {
	// 백준 9461 파도반 수열
	public static Long[] seq = new Long[101];
	/*
	 * dp[i] = dp[i - 2] + dp[i - 3];
	 */

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		seq[0] = 0L;
		seq[1] = 1L;
		seq[2] = 1L;
		seq[3] = 1L;

		int T = in.nextInt();

		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			System.out.println(padovan(N));
		}

	}

	public static long padovan(int N) {
		if (seq[N] == null) { // 탐색하지 않은 인덱스일 경우 재귀호출
			seq[N] = padovan(N - 2) + padovan(N - 3);
		}
		return seq[N];
	}

}
