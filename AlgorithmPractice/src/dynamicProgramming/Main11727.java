package dynamicProgramming;

import java.util.Scanner;

public class Main11727 {
	// 2 * N 타일링 2
	// 기존거에서 덧붙인다고 생각하자
	// 그러면 점화식이 새워진다
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[1] = 1;
		if (N >= 2) {
			dp[2] = 3;
			for (int i = 3; i < N + 1; i++) {
				dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
			}

		}

		System.out.println(dp[N]);
	}

}
