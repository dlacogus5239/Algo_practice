package baekJoon;

import java.util.Scanner;

public class Main11726 {
	// 백준 11726 2xN 타일링
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		sc.close();
		// input END
		int[] dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = 1;
		if (N >= 2) {
			dp[2] = 2;
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}
		}

		System.out.println(dp[N]);
	}

}
