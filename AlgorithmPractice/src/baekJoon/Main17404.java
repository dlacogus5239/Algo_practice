package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17404 { // 백준 17404 RGB 거리 2
	static int[][] cost;
	static final int INF = 1_000_001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		cost = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}

		// N번쨰 집, RGB
		int[][] dp = new int[N + 1][3];

		// 하나를 고정 시키고 구하고 * 3

		int answer = Integer.MAX_VALUE;
		// 하나씩 고정시키고
		for (int start = 0; start < 3; start++) {

			for (int i = 0; i < 3; i++) {
				if (i == start) {
					dp[1][i] = cost[1][i];
				} else {
					dp[1][i] = INF;
				}
			}

			for (int i = 2; i <= N; i++) {
				for (int j = 0; j < 3; j++) {
					dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + cost[i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				if (i != start) {
					answer = Math.min(answer, dp[N][i]);
				}
			}

//			for (int i = 0; i < 3; i++) {
//				System.out.print(dp[N][i] + " ");
//			}
//			System.out.println();
		}

		System.out.println(answer);
	}

}
