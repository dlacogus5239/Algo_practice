package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
	// 백준 2579 계단 오르기
	static int N;
	static int[] stair;
	static Integer[] dp;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stair = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp = new Integer[N + 1];
		dp[1] = stair[1];
		if (N < 2) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] = stair[1] + stair[2];
		if (N == 2) {
			System.out.println(dp[2]);
			return;
		}
		dp[3] = Math.max(stair[1], stair[2]) + stair[3];
		if(N == 3) {
			System.out.println(dp[3]);
			return;
		}

		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
		}

		System.out.println(dp[N]);
	}

}
