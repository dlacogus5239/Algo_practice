package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
	// 백준 11660 구간 합 구하기 5
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static StringTokenizer[] fromTo;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		fromTo = new StringTokenizer[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			fromTo[i] = new StringTokenizer(br.readLine());
		}

		// input END

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
			}
		}

		StringTokenizer cur;
		for (int i = 0; i < M; i++) {
			cur = fromTo[i];
			int x1 = Integer.parseInt(cur.nextToken());
			int y1 = Integer.parseInt(cur.nextToken());
			int x2 = Integer.parseInt(cur.nextToken());
			int y2 = Integer.parseInt(cur.nextToken());
			System.out.println(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
		}
	}

}
