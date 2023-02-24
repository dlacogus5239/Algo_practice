package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9465 {
	// 백준 9465 스티커

	static int[][] sticker;
	static int[][] dp;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());

			sticker = new int[2][N + 1];

			dp = new int[2][N + 1];

			int answer = 0;
			StringTokenizer st;
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 초기화
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];

			// 최대값은 순차적으로 탐색하면서 대각선으로 가면서 최댓값 갱신
			dp[0][1] = sticker[1][0] + sticker[0][1];
			dp[1][1] = sticker[0][0] + sticker[1][1];

			for (int i = 2; i < N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
			}

			answer = Math.max(dp[1][N - 1], dp[0][N - 1]);

			System.out.println(answer);

		}

	}

}
