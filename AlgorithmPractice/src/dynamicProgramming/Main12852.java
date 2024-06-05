package dynamicProgramming;

import java.util.Scanner;

public class Main12852 {
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] dp = new int[N + 1][2];
		dp[1][0] = 0;
		dp[1][1] = 0;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + 1;
			dp[i][1] = i - 1;

			if (i % 2 == 0) {
				if (dp[i][0] > dp[i / 2][0] + 1) {
					dp[i][0] = dp[i / 2][0] + 1;
					dp[i][1] = i / 2;
				}
			}
			if (i % 3 == 0) {
				if (dp[i][0] > dp[i / 3][0] + 1) {
					dp[i][0] = dp[i / 3][0] + 1;
					dp[i][1] = i / 3;
				}
			}
		}
		System.out.println(dp[N][0]);
		int idx = N;
		StringBuilder sb = new StringBuilder();
		while (idx >= 1) {
			sb.append(idx).append(" ");
			idx = dp[idx][1];
		}
		System.out.println(sb.toString());
	}

}
