package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main10844 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1] % 1_000_000_000;
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
			}
			dp[i][9] = dp[i - 1][8] % 1_000_000_000;
		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (dp[N][i] + answer) % 1_000_000_000;
		}

		System.out.println(answer);
	}

}
