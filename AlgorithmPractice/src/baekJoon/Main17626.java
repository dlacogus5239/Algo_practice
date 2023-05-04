package baekJoon;

import java.io.IOException;
import java.util.Scanner;

public class Main17626 {
	// 백준 17626 Four Squares
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int[] dp = new int[N + 1];
		dp[1] = 1;

		int min;

		for (int i = 2; i <= N; i++) {
			min = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				int tmp = i - j * j;
				min = Math.min(min, dp[tmp]);
			}

			dp[i] = min + 1;
		}

		System.out.println(dp[N]);
	}

}
