package dynamicProgramming;

import java.util.Scanner;

public class Main1699 {
	static final int INF = 1_00_010;

	// https://chanhuiseok.github.io/posts/baek-10/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[INF];

		for (int i = 1; i <= N; i++) {
			dp[i] = i; // 1^2 으로 N까지 모든 항 초기화
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[N]);
	}

}
