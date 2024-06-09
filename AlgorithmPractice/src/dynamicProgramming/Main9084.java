package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9084 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] coins;
		int N;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int target;
		int[][] dp;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			coins = new int[N + 1]; // 각 동전의 가치(액수) 저장
			st = new StringTokenizer(br.readLine());
			coins[0] = 1;
			for (int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			target = Integer.parseInt(br.readLine()); // 만들어야 할 액수
			dp = new int[N + 1][target + 1];
			for (int i = 0; i < N + 1; i++) {
				dp[i][0] = 1;
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < target + 1; j++) {
					dp[i][j] = dp[i - 1][j];
					if (j - coins[i] >= 0) {
						dp[i][j] += dp[i][j - coins[i]];
					}
				}
			}
			sb.append(dp[N][target]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
