package baekJoon;

import java.util.Scanner;

public class Main11727 {
	// 백준 11727 2xN 타일링

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;
		if (N == 1) {
			System.out.println(dp[1]);
			return;
		}
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;

		}

		System.out.println(dp[N]);
	}

}
