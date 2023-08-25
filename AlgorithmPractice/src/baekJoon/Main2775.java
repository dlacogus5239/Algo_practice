package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2775 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			dp[0][i] = i;

		}

		for (int i = 1; i <= 14; i++) {
			dp[i][1] = 1;
			for (int j = 2; j <= 14; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

			}
		}

//		for (int i = 0; i < 15; i++) {
//			for (int j = 1; j < 15; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]).append("\n");
		}

		System.out.println(sb.toString());
	}

}
