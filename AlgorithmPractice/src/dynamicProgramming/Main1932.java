package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < i + 1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j - 1 < 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				}

			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		Arrays.sort(dp[N - 1]);

		System.out.println(dp[N - 1][N - 1]);

	}

}
